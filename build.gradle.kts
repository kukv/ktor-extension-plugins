import org.jetbrains.dokka.gradle.DokkaPlugin

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spotless)
    alias(libs.plugins.kotlin.dokka)
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
    apply<DokkaPlugin>()

    tasks {
        val sourcesJar by creating(Jar::class) {
            val sourceSets: SourceSetContainer by project
            archiveClassifier.set("sources")
            from(sourceSets["main"].allSource)
        }

        register<Jar>("dokkaHtmlJar") {
            dependsOn(dokkaHtml)
            from(dokkaHtml.flatMap { it.outputDirectory })
            archiveClassifier.set("html-docs")
        }

        register<Jar>("dokkaJavadocJar") {
            dependsOn(dokkaJavadoc)
            from(dokkaJavadoc.flatMap { it.outputDirectory })
            archiveClassifier.set("javadoc")
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
