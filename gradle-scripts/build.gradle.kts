plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.20")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.25.0")
    implementation("io.github.gradle-nexus:publish-plugin:2.0.0")
}
