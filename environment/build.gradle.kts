// なぜかサブプロジェクトの方はファイル自体にアノテーションを付与してあげないとビルドできなくなってしまう
// https://github.com/gradle/gradle/issues/23784
@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(libs.ktor.server.core)

    implementation(libs.kotlinx.datetime)

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }
}
