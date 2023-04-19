plugins {
    id("kotlin-module")
    kotlin("plugin.serialization") version "1.8.20"
}

dependencies {
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.4")
    implementation("io.ktor:ktor-server-core:2.2.4")
    implementation("io.ktor:ktor-server-cio:2.3.0")
    implementation("io.ktor:ktor-server-content-negotiation:2.2.4")

    implementation("ch.qos.logback:logback-classic:1.4.6")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation("jp.kukv.ktor-extension-plugins:environment:0.1.0")
}
