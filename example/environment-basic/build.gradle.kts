import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    application
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.22"
}

dependencies {
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.7")

    implementation("io.ktor:ktor-server-core:2.3.7")
    implementation("io.ktor:ktor-server-cio:2.3.7")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.7")

    implementation("ch.qos.logback:logback-classic:1.4.14")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")

    implementation("jp.kukv.ktor-extension-plugins:environment:0.1.3")
}

application {
    mainClass.set("jp.kukv.example.ApplicationKt")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of("17"))
    }
}

tasks {
    withType<KotlinJvmCompile> {
        kotlinOptions {
            jvmTarget = "17"
            apiVersion = "1.8"
            languageVersion = "1.8"
        }
    }

    withType<Test> {
        useJUnitPlatform()
    }
}
