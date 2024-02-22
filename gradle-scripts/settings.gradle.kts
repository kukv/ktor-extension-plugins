dependencyResolutionManagement {
    versionCatalogs {
        create("pluginsDependency") {
            from(files("../gradle/plugins-dependency.versions.toml"))
        }
    }
}

rootProject.name = "gradle-scripts"
