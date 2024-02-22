package jp.kukv._extensions

import org.gradle.api.provider.Property

infix fun <T> Property<T>.by(value: T) {
    set(value)
}
