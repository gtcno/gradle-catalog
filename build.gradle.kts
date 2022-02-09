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
    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/gtcno/gradle-catalog")
        }
    }
    publications {
        create<MavenPublication>("maven") {
            this.groupId = "com.github.gtcno"
            from(components["versionCatalog"])
        }
    }
}


