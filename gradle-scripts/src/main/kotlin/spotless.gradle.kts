plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("$buildDir/**/*.kt", "**/bin/**/*.kt", "**/build/**/*.kt")

        ktlint("0.48.2")
    }

    kotlinGradle {
        target("*.gradle.kts", "**/*.gradle.kts")
        targetExclude("**/build/**/*.kts")

        ktlint("0.48.2")
    }
}
