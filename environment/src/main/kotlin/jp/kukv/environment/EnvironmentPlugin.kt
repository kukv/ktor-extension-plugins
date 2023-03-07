package jp.kukv.environment

import io.ktor.server.application.createApplicationPlugin
import io.ktor.server.config.ApplicationConfig
import io.ktor.util.InternalAPI

/**
 * Plugin Configuration.
 *
 * @property config Ktor environment setting
 */
class EnvironmentConfiguration {
    var config: ApplicationConfig? = null
}

@OptIn(InternalAPI::class)
val EnvironmentPlugin = createApplicationPlugin(name = "Environment", ::EnvironmentConfiguration) {

    val environment = Environment.init(pluginConfig.config)
    EnvironmentContext.register(environment)
}
