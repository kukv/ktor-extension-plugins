package jp.kukv.example

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.DatabaseConfig
import javax.sql.DataSource

data class ExposedDataSourceProperties(private val dataSource: DataSource) {

    fun connect(): Database = Database.connect(
        datasource = dataSource,
        databaseConfig = DatabaseConfig.invoke { useNestedTransactions = true }
    )
}
