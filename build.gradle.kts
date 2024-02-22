plugins {
    id("jp.kukv.gradle.documentation.dokka")
    id("jp.kukv.gradle.format.spotless-for-kotlin")
    id("jp.kukv.gradle.format.spotless-for-kotlin-dsl")
    id("jp.kukv.gradle.publish.nexus-publishing")
    id("jp.kukv.gradle.publish.signing-publish")
}

allprojects {
    group = "jp.kukv.ktor-extension-plugins"
    version = "0.1.3"

    repositories {
        mavenCentral()
    }
}
