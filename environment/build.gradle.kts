// なぜかサブプロジェクトの方はファイル自体にアノテーションを付与してあげないとビルドできなくなってしまう
// https://github.com/gradle/gradle/issues/23784
@file:Suppress("DSL_SCOPE_VIOLATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    id("org.jetbrains.dokka")
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(libs.ktor.server.core)

    implementation(libs.kotlinx.datetime)

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
