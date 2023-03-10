@file:Suppress("unused")

package jp.kukv.environment

import io.ktor.server.application.createApplicationPlugin
import io.ktor.util.InternalAPI

@OptIn(InternalAPI::class)
val EnvironmentPlugin = createApplicationPlugin(name = "Environment") {

    val environment = Environment.init(applicationConfig)
    EnvironmentContext.register(environment)
}
