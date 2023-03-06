package jp.kukv.environment

import io.ktor.util.InternalAPI

internal object EnvironmentContext {

    @OptIn(InternalAPI::class)
    private lateinit var env: Environment

    @OptIn(InternalAPI::class)
    internal fun register(environment: Environment) {
        env = environment
    }

    @OptIn(InternalAPI::class)
    internal fun get(): Environment {
        if (!EnvironmentContext::env.isInitialized) {
            throw InitializationFailureException("Environment plugin not initialized yet")
        }
        return env
    }
}
