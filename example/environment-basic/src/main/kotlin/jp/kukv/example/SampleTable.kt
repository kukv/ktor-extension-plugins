package jp.kukv.example

import org.jetbrains.exposed.sql.Table

object SampleTable : Table("sample") {
    val id = integer("id")
    val name = varchar("name", 255)

    override val primaryKey = PrimaryKey(id)
}
