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
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.koin.ksp.generated.module
import org.koin.ktor.ext.inject
import org.koin.ktor.plugin.koin

fun Application.configuration() {
    koin {
        modules(DIModules().module)
    }

    install(EnvironmentPlugin) {
        config = environment.config
    }

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
            }
        )
    }

    val dataSource by inject<ExposedDataSourceProperties>()
    dataSource.connect()

    runBlocking {
        init()
    }

    routing {
        get("/{id}") {
            val id = call.parameters["id"]?.toInt()!!
            val name = newSuspendedTransaction {
                SampleTable
                    .select { SampleTable.id eq id }
                    .firstOrNull()
                    ?.let { it[SampleTable.name] } ?: RuntimeException("not found.")
            }
            call.respond(name)
        }
    }
}
