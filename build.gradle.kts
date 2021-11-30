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

val tomlFile = layout.buildDirectory.file("/libs.versions.toml")
val tomlArtifact = artifacts.add("archives", tomlFile.get().asFile) {
    type = "toml"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            this.groupId = "no.gtc.common"
            this.artifactId = "versionCatalog"
            this.artifact(tomlArtifact)
            from(components["versionCatalog"])
        }
    }
}


