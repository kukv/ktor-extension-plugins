plugins {
    id("dokka")
    id("spotless")
    id("nexus-publishing")
    id("signing-publish")
}

allprojects {
    group = "jp.kukv.ktor-extension-plugins"
    version = "0.1.1"

    repositories {
        mavenCentral()
    }
}
