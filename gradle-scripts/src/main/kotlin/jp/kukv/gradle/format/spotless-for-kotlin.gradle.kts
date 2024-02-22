package jp.kukv.gradle.format

import gradle.kotlin.dsl.accessors._1cd57f1730507bf1765dcbcf508dc5fb.spotless

plugins {
    id("com.diffplug.spotless")
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**/*.kt", "**/bin/**/*.kt")

        ktlint()
    }
}
