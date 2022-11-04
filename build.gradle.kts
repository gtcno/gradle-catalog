import java.net.URI

plugins {
    `maven-publish`
    `version-catalog`
}

group = "no.gtc.gradle"
version = "SNAPSHOT"

catalog {
    versionCatalog {
        from(files("gradle/libs.versions.toml"))
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            version = System.getenv("RELEASE_TAG") ?: version
            from(components["versionCatalog"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = URI.create("https://maven.pkg.github.com/gtcno/gradle-catalog")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
