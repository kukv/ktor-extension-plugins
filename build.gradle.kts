@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spotless)
    `maven-publish`
}

allprojects {

    group = "jp.kukv.ktor-extensions-plugins"
    version = "0.0.5"

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

subprojects {

    apply(plugin = "org.gradle.maven-publish")

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()

                afterEvaluate {
                    from(components["java"])
                }

                pom {
                    name.set("ktor-extension-plugins")
                    description.set("ktor-extension-plugins")
                    url.set("https://github.com/kukv/ktor-extension-plugins")
                }
            }
        }
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("$buildDir/**/*.kt", "**/bin/**/*.kt", "**/build/**/*.kt")

        ktlint("0.48.2")
    }

    kotlinGradle {
        target("*.gradle.kts", "**/*.gradle.kts")

        ktlint("0.48.2")
    }
}
