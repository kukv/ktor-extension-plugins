@file:Suppress("unused")

package jp.kukv.environment

import io.ktor.util.InternalAPI

/**
 * An interface that realizes access to property values in a configuration file.
 */
interface EnvironmentComponent {
    @OptIn(InternalAPI::class)
    fun context(): Environment = EnvironmentContext.get()
}

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.inject(key: String): Lazy<T> =
    lazy { context().getTypedPropertyOrThrow<T>(key, T::class) }

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.injectOrDefault(key: String, defaultValue: T): Lazy<T> =
    lazy { context().getTypedPropertyOrDefault<T>(key, defaultValue, T::class) }

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.injectOrNull(key: String): Lazy<T?> =
    lazy { context().getTypedPropertyOrNull<T>(key, T::class) }

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.injectList(key: String): Lazy<List<T>> =
    lazy { context().getTypedPropertiesOrThrow<T>(key, T::class) }

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.injectListOrEmptyList(key: String): Lazy<List<T>> =
    lazy { context().getTypedPropertiesOrEmptyList<T>(key, T::class) }

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.injectListOrDefault(key: String, defaultValue: List<T>): Lazy<List<T>> =
    lazy { context().getTypedPropertiesOrDefault<T>(key, defaultValue, T::class) }

@OptIn(InternalAPI::class)
inline fun <reified T> EnvironmentComponent.injectListOrNull(key: String): Lazy<List<T>?> =
    lazy { context().getTypedPropertiesOrNull<T>(key, T::class) }
