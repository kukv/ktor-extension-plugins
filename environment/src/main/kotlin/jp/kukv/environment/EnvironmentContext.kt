package jp.kukv.environment

internal object EnvironmentContext {

    private lateinit var env: Environment

    internal fun register(environment: Environment) {
        env = environment
    }

    internal fun get(): Environment {
        if (!EnvironmentContext::env.isInitialized) {
            throw InitializationFailureException("Environment plugin not initialized yet")
        }
        return env
    }
}
