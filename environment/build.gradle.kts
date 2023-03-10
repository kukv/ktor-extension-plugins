plugins {
    id("kotlin-module")
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.kotlinx.datetime)
    implementation("com.h2database:h2:2.1.214")
}
