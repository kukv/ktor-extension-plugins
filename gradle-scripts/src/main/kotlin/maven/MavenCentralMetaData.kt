package maven

import by
import org.gradle.api.Project
import org.gradle.api.publish.maven.MavenPom

fun MavenPom.mavenCentralMetadata(project: Project) {
    name by project.name
    description by "Library for ktor extension."
    url by "https://github.com/kukv/ktor-extension-plugins"

    licenses {
        license {
            name by "MIT License"
            url by "https://api.github.com/licenses/mit"
            description by "repo"
        }
    }

    developers {
        developer {
            id by "kukv"
            name by "Koki Nonaka"
        }
    }

    scm {
        connection by "scm:git:git://github.com/kukv/ktor-extension-plugins.git"
        developerConnection by "scm:git:git@github.com:kukv/ktor-extension-plugins.git"
        url by "https://github.com/kukv/ktor-extension-plugins"
    }
}
