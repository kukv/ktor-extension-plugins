package jp.kukv.gradle.publish

import jp.kukv._extensions.by
import jp.kukv.env.Properties
import jp.kukv.env.PropertyKey
import jp.kukv.gradle.publish.maven.mavenCentralMetadata

plugins {
    `java-library`
    `maven-publish`
    signing
}

subprojects {

    apply {
        plugin("java-library")
        plugin("maven-publish")
        plugin("signing")
    }

    tasks {

        register<Jar>("sourcesJar") {
            group = "build"
            dependsOn(classes)
            from(sourceSets["main"].allSource)
            archiveClassifier by "sources"
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
            val properties = Properties.factory()
            useInMemoryPgpKeys(
                properties.find(PropertyKey.SIGNING_KEY_ID, ""),
                properties.find(PropertyKey.SIGNING_SECRET, ""),
                properties.find(PropertyKey.SIGNING_PASSPHRASE, "")
            )
            sign(publishing.publications["mavenJava"])
        }
    }
}
