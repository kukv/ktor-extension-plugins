package jp.kukv.gradle.publish

import jp.kukv._extensions.by
import jp.kukv.env.Properties
import jp.kukv.env.PropertyKey

plugins {
    id("io.github.gradle-nexus.publish-plugin")
}

nexusPublishing {
    repositories {

        sonatype {
            val properties = Properties.factory()
            nexusUrl by uri(properties.find(PropertyKey.REPOSITORY_URL, ""))
            snapshotRepositoryUrl by uri(properties.find(PropertyKey.SNAPSHOT_REPOSITORY_URL, ""))
            stagingProfileId by properties.find(PropertyKey.SONATYPE_STAGING_PROFILE_ID, "")
            username by properties.find(PropertyKey.OSSRH_USERNAME, "")
            password by properties.find(PropertyKey.OSSRH_PASSWORD, "")
        }
    }
}
