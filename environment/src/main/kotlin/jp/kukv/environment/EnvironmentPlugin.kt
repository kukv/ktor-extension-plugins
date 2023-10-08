@file:Suppress("unused")

package jp.kukv.environment

import io.ktor.server.application.createApplicationPlugin

val EnvironmentPlugin =
    createApplicationPlugin(name = "Environment") {

        val environment = Environment.init(applicationConfig)
        EnvironmentContext.register(environment)
    }
