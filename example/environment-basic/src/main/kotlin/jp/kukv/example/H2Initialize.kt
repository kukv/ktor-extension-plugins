package jp.kukv.example

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

suspend fun init() {
    newSuspendedTransaction {
        SchemaUtils.create(SampleTable)
        SampleTable.insert {
            it[id] = 1
            it[name] = "A1"
        }
    }
}
