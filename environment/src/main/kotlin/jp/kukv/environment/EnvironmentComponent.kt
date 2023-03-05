package jp.kukv.environment

public interface EnvironmentComponent {
    public fun context(): Environment = EnvironmentContext.get()
}

public inline fun <reified T> EnvironmentComponent.inject(key: String): Lazy<T> =
    lazy { context().getTypedPropertyOrThrow<T>(key, T::class) }

public inline fun <reified T> EnvironmentComponent.injectOrDefault(key: String, defaultValue: T): Lazy<T> =
    lazy { context().getTypedPropertyOrDefault<T>(key, defaultValue, T::class) }

public inline fun <reified T> EnvironmentComponent.injectOrNull(key: String): Lazy<T?> =
    lazy { context().getTypedPropertyOrNull<T>(key, T::class) }
