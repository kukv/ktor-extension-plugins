package jp.kukv.gradle.format

import gradle.kotlin.dsl.accessors._1cd57f1730507bf1765dcbcf508dc5fb.spotless

plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlinGradle {
        target("*.gradle.kts", "**/*.gradle.kts")
        targetExclude("**/build/**/*.kts")

        ktlint()
    }
}
