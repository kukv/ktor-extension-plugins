package jp.kukv.gradle.documentation

import gradle.kotlin.dsl.accessors._cb6cb9110f5ef9edc63ba98f09b0c2ae.dokkaHtml
import gradle.kotlin.dsl.accessors._cb6cb9110f5ef9edc63ba98f09b0c2ae.dokkaJavadoc
import jp.kukv._extensions.by
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.dokka.DokkaConfiguration.Visibility
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
    id("org.jetbrains.dokka")
}

subprojects {

    apply {
        plugin("org.jetbrains.dokka")
    }

    tasks {
        withType<DokkaTaskPartial> {
            dokkaSourceSets.configureEach {
                documentedVisibilities.set(setOf(Visibility.PUBLIC, Visibility.PROTECTED))
            }
        }

        register<Jar>("dokkaHtmlJar") {
            group = "documentation"
            dependsOn(dokkaHtml)
            from(dokkaHtml.flatMap { it.outputDirectory })
            archiveClassifier by "html-docs"
        }

        register<Jar>("dokkaJavadocJar") {
            group = "documentation"
            dependsOn(dokkaJavadoc)
            from(dokkaJavadoc.flatMap { it.outputDirectory })
            archiveClassifier by "javadoc"
        }
    }
}

tasks {
    withType<DokkaMultiModuleTask> {
        moduleName by "Ktor Extension Plugins"
    }
}
