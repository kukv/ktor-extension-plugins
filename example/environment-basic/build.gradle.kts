
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(exampleDependency.plugins.kotlin.serialization)
}

dependencies {
    implementation(exampleDependency.ktor.serialization)

    implementation(libs.ktor.server.core)
    implementation(exampleDependency.ktor.server.cio)
    implementation(exampleDependency.ktor.server.content.negotiation)

    implementation(libs.logback.classic)

    implementation(libs.kotlin.datetime)

    implementation(exampleDependency.ktor.extension.environment)
}

application {
    mainClass.set("jp.kukv.example.ApplicationKt")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.java.get()))
    }
}

tasks {
    withType<KotlinJvmCompile> {
        kotlinOptions {
            jvmTarget = libs.versions.java.get()
            apiVersion = libs.versions.kotlin.api.get()
            languageVersion = libs.versions.kotlin.api.get()
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
