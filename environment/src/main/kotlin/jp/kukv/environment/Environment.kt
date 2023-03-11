package jp.kukv.environment

import io.ktor.server.config.ApplicationConfig
import io.ktor.server.config.ApplicationConfigValue
import kotlinx.datetime.toLocalDate
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.toLocalTime
import org.slf4j.LoggerFactory
import java.lang.ClassCastException
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.reflect.KClass
import java.time.LocalDate as JLocalDate
import java.time.LocalDateTime as JLocalDateTime
import java.time.LocalTime as JLocalTime
import kotlinx.datetime.LocalDate as KLocalDate
import kotlinx.datetime.LocalDateTime as KLocalDateTime
import kotlinx.datetime.LocalTime as KLocalTime

class Environment private constructor(private val delegate: ApplicationConfig) {

    @PublishedApi
    internal fun <T> getTypedPropertiesOrEmptyList(key: String, clazz: KClass<*>): List<T> =
        getTypedPropertiesOrNull<T>(key, clazz) ?: emptyList()

    @PublishedApi
    internal fun <T> getTypedPropertyOrDefault(key: String, defaultValue: T, clazz: KClass<*>): T =
        getTypedPropertyOrNull<T>(key, clazz) ?: defaultValue

    @PublishedApi
    internal fun <T> getTypedPropertiesOrDefault(key: String, defaultValue: List<T>, clazz: KClass<*>): List<T> =
        getTypedPropertiesOrNull<T>(key, clazz) ?: defaultValue

    @PublishedApi
    internal fun <T> getTypedPropertyOrThrow(key: String, clazz: KClass<*>): T =
        getTypedPropertyOrNull<T>(key, clazz) ?: throw KeyNotFoundException("Property $key does not exist")

    @PublishedApi
    internal fun <T> getTypedPropertiesOrThrow(key: String, clazz: KClass<*>): List<T> =
        getTypedPropertiesOrNull<T>(key, clazz) ?: throw KeyNotFoundException("Property $key does not exist")

    @PublishedApi
    internal fun <T> getTypedPropertyOrNull(key: String, clazz: KClass<*>): T? {
        val value = getString(key) ?: return null
        return cast(value, clazz)
    }

    @PublishedApi
    internal fun <T> getTypedPropertiesOrNull(key: String, clazz: KClass<*>): List<T>? {
        val values = getList(key) ?: return null

        return values.map { cast(it, clazz) }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> cast(value: String, clazz: KClass<*>): T = when (clazz) {
        // kotlin primitive
        String::class -> value
        Byte::class -> value.toByte()
        Short::class -> value.toShort()
        Int::class -> value.toInt()
        Long::class -> value.toLong()
        Float::class -> value.toFloat()
        Double::class -> value.toDouble()
        Boolean::class -> value.toBoolean()
        // java object
        BigDecimal::class -> value.toBigDecimal()
        BigInteger::class -> value.toBigInteger()
        JLocalDate::class -> JLocalDate.parse(value)
        JLocalDateTime::class -> JLocalDateTime.parse(value)
        JLocalTime::class -> JLocalTime.parse(value)
        // kotlin object
        KLocalDate::class -> value.toLocalDate()
        KLocalDateTime::class -> value.toLocalDateTime()
        KLocalTime::class -> value.toLocalTime()
        else -> throw ClassCastException("Type: [$clazz] not supported.")
    } as T

    private fun getString(key: String): String? = getApplicationConfigValue(key)?.getString()
    private fun getList(key: String): List<String>? = getApplicationConfigValue(key)?.getList()
    private fun getApplicationConfigValue(key: String): ApplicationConfigValue? = delegate.propertyOrNull(key)

    internal companion object {

        private val log = LoggerFactory.getLogger(Environment::class.java)

        internal fun init(config: ApplicationConfig?): Environment {
            if (config == null) {
                throw InitializationFailureException("ApplicationConfig does not exist.")
            }
            log.info("Starting Environment Plugin")
            return Environment(config)
        }
    }
}
