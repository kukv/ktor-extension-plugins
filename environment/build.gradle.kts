import jp.kukv._extensions.by
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

dependencies {
    implementation(libs.kotlin.datetime)
    implementation(libs.ktor.server.core)
    implementation(libs.logback.classic)
}

kotlin {
    jvmToolchain {
        languageVersion by JavaLanguageVersion.of(libs.versions.java.get())
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
