package jp.kukv.env

import kotlin.jvm.JvmInline

@JvmInline
value class Properties(private val map: Map<PropertyKey, PropertyValue>) {
    fun find(key: PropertyKey): String =
        map[key]?.let { it() } ?: throw IllegalStateException("Corresponding environment variable key value does not exist.")

    fun find(
        key: PropertyKey,
        defaultValue: String
    ): String = map[key]?.let { it() } ?: defaultValue

    override fun toString(): String {
        return map.toString()
    }

    companion object {
        fun factory(): Properties {
            val temporary = System.getenv()

            val map =
                temporary
                    .filter { (key, _) ->
                        val targetKey = PropertyKey.values()
                        val targetKeyName = targetKey.map { it.name }
                        targetKeyName.contains(key)
                    }
                    .entries
                    .associate { (key, value) ->
                        val propertyKey = PropertyKey.valueOf(key)
                        val propertyValue = PropertyValue(value)
                        propertyKey to propertyValue
                    }

            return Properties(map)
        }
    }
}
