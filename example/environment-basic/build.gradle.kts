plugins {
    id("kotlin-module")
    kotlin("plugin.serialization") version "1.9.0"
}

dependencies {
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.2")

    implementation("io.ktor:ktor-server-core:2.3.2")
    implementation("io.ktor:ktor-server-cio:2.3.4")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.2")

    implementation("ch.qos.logback:logback-classic:1.4.8")

    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    implementation("jp.kukv.ktor-extension-plugins:environment:0.1.1")
}
