package jp.kukv.example

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import jp.kukv.environment.EnvironmentComponent
import jp.kukv.environment.inject
import jp.kukv.environment.injectOrDefault
import jp.kukv.environment.injectOrNull
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("jp.kukv.example")
class DIModules : EnvironmentComponent {

    @Single
    fun exposedDataSourceProperties(): ExposedDataSourceProperties {
        val jdbcUrl by inject<String>("config.dataSource.jdbcUrl")
        val driver by inject<String>("config.dataSource.driverClassName")
        val userName by inject<String>("config.dataSource.userName")
        val password by injectOrNull<String>("config.dataSource.password")
        val maximumPoolSize by injectOrDefault("config.dataSource.maximumPoolSize", 3)
        val autoCommit by injectOrDefault("config.dataSource.autoCommit", false)
        val transactionIsolation by injectOrDefault("config.dataSource.transactionIsolation", "TRANSACTION_REPEATABLE_READ")

        val dataSource = HikariDataSource(
            HikariConfig().apply {
                this.jdbcUrl = jdbcUrl
                this.driverClassName = driver
                this.username = userName
                this.password = password
                this.maximumPoolSize = maximumPoolSize
                this.isAutoCommit = autoCommit
                this.transactionIsolation = transactionIsolation
            }
        )

        return ExposedDataSourceProperties(dataSource)
    }
}
