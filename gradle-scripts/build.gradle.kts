plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.8.10")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.18.0")
    implementation("io.github.gradle-nexus:publish-plugin:1.3.0")
}
