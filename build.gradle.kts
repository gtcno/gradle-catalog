plugins {
    `base`
    `version-catalog`
    `maven-publish`
}

object Groups {
    const val ktor = "io.ktor"
    const val gcp = "com.google.cloud"
    const val jackson_core = "com.fasterxml.jackson.core"
}

catalog {
    versionCatalog {
        version("ktor", "1.6.5")
        alias("ktor-server").to(Groups.ktor, "ktor-server").versionRef("ktor")
        alias("ktor-client-auth-jvm").to(Groups.ktor, "ktor-client-auth-jvm").versionRef("ktor")
        alias("ktor-client-cio").to(Groups.ktor, "ktor-client-cio").versionRef("ktor")
        alias("ktor-client-jackson").to(Groups.ktor, "ktor-client-jackson").versionRef("ktor")
        alias("ktor-client-logging-jvm").to(Groups.ktor, "ktor-client-logging-jvm").versionRef("ktor")

        version("gcp-bom", "24.0.0")
        alias("google-cloud-secretmanager").to(Groups.gcp, "google-cloud-secretmanager")
        alias("google-cloud-storage").to(Groups.gcp, "google-cloud-storage")

        version("jackson", "2.13")
        alias("jackson-core").to(Groups.jackson_core, "jackson-core")
        alias("jackson-annotations").to(Groups.jackson_core, "jackson-annotations")
        alias("jackson-databind").to(Groups.jackson_core, "jackson-databind")
        alias("jackson-datatype-jsr310").to("com.fasterxml.jackson.datatype", "jackson-datatype-jsr310")

        alias("konfig").to("com.natpryce:konfig:1.6.10.0")
        alias("telegram").to("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.0.3")
    }
}

publishing {
    publications {
        create<MavenPublication>("catalog") {
            this.groupId = "no.gtc.common"
            this.artifactId = "versionCatalog"
            from(components["versionCatalog"])
        }
    }
}


