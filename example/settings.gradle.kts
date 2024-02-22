dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("exampleDependency") {
            from(files("../gradle/example-dependency.versions.toml"))
        }
    }
}

includeBuild("../gradle-scripts")

rootProject.name = "example"

include("environment-basic")
