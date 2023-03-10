import env.EnvConfig
import env.PropertyKey

plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

val envConfig = EnvConfig.factory()

nexusPublishing {
    repositories {

        sonatype {
            nexusUrl.set(uri(envConfig.propertyOrDefault(PropertyKey.REPOSITORY_URL, "")))
            snapshotRepositoryUrl.set(uri(envConfig.propertyOrDefault(PropertyKey.SNAPSHOT_REPOSITORY_URL, "")))
            stagingProfileId.set(envConfig.propertyOrDefault(PropertyKey.SONATYPE_STAGING_PROFILE_ID, ""))
            username.set(envConfig.propertyOrDefault(PropertyKey.OSSRH_USERNAME, ""))
            password.set(envConfig.propertyOrDefault(PropertyKey.OSSRH_PASSWORD, ""))
        }
    }
}
