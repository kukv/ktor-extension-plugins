package jp.kukv.environment

import io.ktor.server.application.createApplicationPlugin
import io.ktor.server.config.ApplicationConfig

public class EnvironmentConfiguration {
    var config: ApplicationConfig? = null
}

public val EnvironmentPlugin = createApplicationPlugin(name = "Environment", ::EnvironmentConfiguration) {

    val environment = Environment.init(pluginConfig.config)
    EnvironmentContext.register(environment)
}
