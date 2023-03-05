@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.spotless)
}

allprojects {
    repositories {
        mavenCentral()
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
