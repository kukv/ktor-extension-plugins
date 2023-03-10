import env.EnvConfig
import env.PropertyKey
import maven.mavenCentralMetadata

plugins {
    `java-library`
    signing
    `maven-publish`
}

val envConfig = EnvConfig.factory()

subprojects {

    apply {
        plugin("java-library")
        plugin("signing")
        plugin("maven-publish")
    }

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
                        mavenCentralMetadata(project)
                    }
                }
            }
        }

        signing {
            useInMemoryPgpKeys(
                envConfig.propertyOrDefault(PropertyKey.SIGNING_KEY_ID, ""),
                envConfig.propertyOrDefault(PropertyKey.SIGNING_SECRET, ""),
                envConfig.propertyOrDefault(PropertyKey.SIGNING_PASSPHRASE, "")
            )
            sign(publishing.publications["mavenJava"])
        }
    }
}
