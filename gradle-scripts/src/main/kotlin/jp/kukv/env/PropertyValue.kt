package jp.kukv.env

import kotlin.jvm.JvmInline

@JvmInline
value class PropertyValue(private val value: String?) {
    operator fun invoke() = value

    override fun toString() = value.let { value } ?: "null value"
}
