plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.9.10")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.23.3")
    implementation("io.github.gradle-nexus:publish-plugin:1.3.0")
}
