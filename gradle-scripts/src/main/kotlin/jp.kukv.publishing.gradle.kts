import env.ENV
import env.PropertyKey

plugins {
    id("io.github.gradle-nexus.publish-plugin")
    `java-library`
    signing
    `maven-publish`
}

val env = ENV.factory()

subprojects {

    apply(plugin = "java-library")
    apply(plugin = "signing")
    apply(plugin = "maven-publish")

    tasks {

        register<Jar>("sourcesJar") {
            group = "build"
            dependsOn(classes)
            from(sourceSets["main"].allSource)
            archiveClassifier.set("sources")
        }
    }

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("mavenJava") {
                    from(components["java"])
                    artifact(tasks["dokkaJavadocJar"])
                    artifact(tasks["sourcesJar"])

                    pom {

                        name.set(project.name)
                        description.set("Library for ktor extension.")
                        url.set("https://github.com/kukv/ktor-extension-plugins")

                        licenses {
                            license {

                                name.set("MIT License")
                                url.set("https://api.github.com/licenses/mit")
                                description.set("repo")
                            }
                        }

                        developers {
                            developer {

                                id.set("kukv")
                                name.set("Koki Nonaka")
                            }
                        }

                        scm {

                            connection.set("scm:git:git://github.com/kukv/ktor-extension-plugins.git")
                            developerConnection.set("scm:git:git@github.com:kukv/ktor-extension-plugins.git")
                            url.set("https://github.com/kukv/ktor-extension-plugins")
                        }
                    }
                }
            }
        }

        signing {
            useInMemoryPgpKeys(
                env.propertyOrThrow(PropertyKey.SIGNING_KEY_ID),
                env.propertyOrThrow(PropertyKey.SIGNING_SECRET),
                env.propertyOrThrow(PropertyKey.SIGNING_PASSPHRASE)
            )
            sign(publishing.publications["mavenJava"])
        }
    }
}

nexusPublishing {
    repositories {

        sonatype {

            nexusUrl.set(uri(env.propertyOrThrow(PropertyKey.REPOSITORY_URL)))
            snapshotRepositoryUrl.set(uri(env.propertyOrThrow(PropertyKey.SNAPSHOT_REPOSITORY_URL)))
            stagingProfileId.set(env.propertyOrThrow(PropertyKey.SONATYPE_STAGING_PROFILE_ID))
            username.set(env.propertyOrThrow(PropertyKey.OSSRH_USERNAME))
            password.set(env.propertyOrThrow(PropertyKey.OSSRH_PASSWORD))
        }
    }
}
