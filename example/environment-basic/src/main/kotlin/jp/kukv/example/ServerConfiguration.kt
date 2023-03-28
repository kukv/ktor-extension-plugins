package jp.kukv.example

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import jp.kukv.environment.EnvironmentPlugin
import jp.kukv.environment.inject
import kotlinx.serialization.json.Json
import org.slf4j.LoggerFactory

private val log = LoggerFactory.getLogger("example application")

fun Application.configuration() {
    install(EnvironmentPlugin)

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }

    val envMode by inject<String>("ktor.environment")
    log.info("Application Mode - $envMode")

    routing {
        get("/purchase_history") {
            call.respond(PurchaseHistoryResponse.factory())
        }
    }
}
