plugins {
    `maven-publish`
    `version-catalog`
}

group = "no.gtc.gradle"
version = "0.0.1"

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["versionCatalog"])
        }
    }
}
