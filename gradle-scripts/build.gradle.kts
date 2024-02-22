plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation(pluginsDependency.dokka)
    implementation(pluginsDependency.spotless)
    implementation(pluginsDependency.nexus.publish)
}
