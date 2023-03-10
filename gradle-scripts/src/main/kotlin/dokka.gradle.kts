
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
