import env.EnvConfig
import env.PropertyKey

plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

val envConfig = EnvConfig.factory()

nexusPublishing {
    repositories {

        sonatype {
            nexusUrl by uri(envConfig.propertyOrDefault(PropertyKey.REPOSITORY_URL, ""))
            snapshotRepositoryUrl by uri(envConfig.propertyOrDefault(PropertyKey.SNAPSHOT_REPOSITORY_URL, ""))
            stagingProfileId by envConfig.propertyOrDefault(PropertyKey.SONATYPE_STAGING_PROFILE_ID, "")
            username by envConfig.propertyOrDefault(PropertyKey.OSSRH_USERNAME, "")
            password by envConfig.propertyOrDefault(PropertyKey.OSSRH_PASSWORD, "")
        }
    }
}
