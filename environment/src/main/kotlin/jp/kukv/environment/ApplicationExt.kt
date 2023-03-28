package jp.kukv.environment

import io.ktor.server.application.Application

inline fun <reified T> Application.inject(key: String): Lazy<T> =
    lazy { context().getTypedPropertyOrThrow<T>(key, T::class) }

inline fun <reified T> Application.inject(key: String, defaultValue: T): Lazy<T> =
    lazy { context().getTypedPropertyOrDefault<T>(key, defaultValue, T::class) }

inline fun <reified T> Application.injectOrNull(key: String): Lazy<T?> =
    lazy { context().getTypedPropertyOrNull<T>(key, T::class) }

inline fun <reified T> Application.injectList(key: String): Lazy<List<T>> =
    lazy { context().getTypedPropertiesOrThrow<T>(key, T::class) }

inline fun <reified T> Application.injectList(key: String, defaultValue: List<T>): Lazy<List<T>> =
    lazy { context().getTypedPropertiesOrDefault<T>(key, defaultValue, T::class) }

inline fun <reified T> Application.injectListOrEmptyList(key: String): Lazy<List<T>> =
    lazy { context().getTypedPropertiesOrDefault<T>(key, emptyList(), T::class) }

inline fun <reified T> Application.injectListOrNull(key: String): Lazy<List<T>?> =
    lazy { context().getTypedPropertiesOrNull<T>(key, T::class) }

@PublishedApi
internal fun Application.context() = EnvironmentContext.get()
