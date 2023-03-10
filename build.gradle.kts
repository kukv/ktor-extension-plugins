
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.jvm)
    id("jp.kukv.dokka")
    id("jp.kukv.spotless")
    id("jp.kukv.publishing")
}

allprojects {

    group = "jp.kukv.ktor-extension-plugins"
    version = "0.0.2"

    repositories {
        mavenCentral()
    }
}

subprojects {

    tasks {
        withType<KotlinJvmCompile> {
            kotlinOptions {
                jvmTarget = "17"
                apiVersion = "1.8"
                languageVersion = "1.8"
            }
        }
    }
}
