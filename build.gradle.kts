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
            this.version = "v2.0.0"
            this.groupId = "no.gtc.common"
            from(components["versionCatalog"])
        }
    }
}


