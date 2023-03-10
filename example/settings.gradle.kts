dependencyResolutionManagement {

    repositories {
        gradlePluginPortal()
    }

    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

includeBuild("../gradle-scripts")

rootProject.name = "example"

include("environment-basic")
