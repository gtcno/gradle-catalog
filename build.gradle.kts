plugins {
    base
    `version-catalog`
    `maven-publish`
}

catalog {
    versionCatalog {
        from(files("$projectDir/libs.versions.toml"))
    }
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            this.version = "v4.0.0"
            this.artifactId = "versionCatalog"
            this.groupId = "no.gtc.common"
            from(components["versionCatalog"])
        }
    }
}


