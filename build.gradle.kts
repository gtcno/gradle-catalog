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
            this.groupId = "com.github.gtcno"
            from(components["versionCatalog"])
        }
    }
}


