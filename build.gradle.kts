plugins {
    kotlin("jvm") version "1.8.10"
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
