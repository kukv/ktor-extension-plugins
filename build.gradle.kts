
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlin.jvm)
    id("dokka")
    id("spotless")
    id("nexus-publishing")
    id("signing-publish")
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
