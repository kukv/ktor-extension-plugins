// なぜかサブプロジェクトの方はファイル自体にアノテーションを付与してあげないとビルドできなくなってしまう
// https://github.com/gradle/gradle/issues/23784
@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("kotlin-module")
    alias(libs.plugins.kotlin.plugin.serialization)
    alias(libs.plugins.google.devtools.ksp)
}

dependencies {
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.cio)
    implementation(libs.ktor.server.content.negotiation)

    implementation(libs.exposed.core)
    implementation(libs.exposed.dao)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.kotlin.datetime)

    implementation(libs.hikari.cp)
    implementation("io.ktor:ktor-server-resources:2.2.4")
    runtimeOnly(libs.h2.db)

    implementation(libs.koin.ktor)
    implementation(libs.koin.annotations)
    ksp(libs.koin.ksp.compiler)

    implementation(libs.logback.classic)

    implementation("jp.kukv.ktor-extension-plugins:environment:0.0.6")
}
