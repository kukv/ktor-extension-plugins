// なぜかサブプロジェクトの方はファイル自体にアノテーションを付与してあげないとビルドできなくなってしまう
// https://github.com/gradle/gradle/issues/23784
@file:Suppress("DSL_SCOPE_VIOLATION")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
    `maven-publish`
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(libs.ktor.server.core)

    implementation(libs.kotlinx.datetime)

    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit5"))
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
    withType<Test> {
        useJUnitPlatform()
    }

    val sourcesJar by creating(Jar::class) {
        val sourceSets: SourceSetContainer by project
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()

            from(components["kotlin"])

            artifact(tasks["sourcesJar"])

            pom {
                name.set("ktor-extension-plugins")
                description.set("ktor-extension-plugins")
                url.set("https://github.com/kukv/ktor-extension-plugins")
            }
        }
    }
}
