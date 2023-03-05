@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spotless)
    `maven-publish`
}

allprojects {

    group = "com.github.kukv"
    version = "0.0.9"

    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}

subprojects {

    apply<JavaLibraryPlugin>()
    apply<MavenPublishPlugin>()

    tasks {
        val sourcesJar by creating(Jar::class) {
            val sourceSets: SourceSetContainer by project
            archiveClassifier.set("sources")
            from(sourceSets["main"].allSource)
        }
    }

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("maven") {
                    groupId = project.group.toString()
                    artifactId = project.name
                    version = project.version.toString()

                    from(components["kotlin"])

                    artifact(tasks["sourcesJar"])

                    pom {
                        name.set("ktor-extension-plugins")
                        description.set("ktor-extension-plugins")
                        url.set("https://github.com/kukv/ktor-extension-plugins")
                    }
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
