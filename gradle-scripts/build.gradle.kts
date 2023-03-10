plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.dokka.gradle.plugin)
    implementation(libs.spotless.gradle.plugin)
    implementation(libs.nexus.publish.plugin)
    implementation("com.h2database:h2:2.1.214")
}
