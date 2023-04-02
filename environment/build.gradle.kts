plugins {
    id("kotlin-module")
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.kotlinx.datetime)
}
