plugins {
    `maven-publish`
    `java-gradle-plugin`
    `kotlin-dsl`
}

group = "no.gtc.gradle"
version = "0.0.1"


gradlePlugin {
    plugins {
        create("kotlin-app") {
            id = "kotlin-app"
            implementationClass = "KotlinAppConventionsPlugin"
        }
    }
}
dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}

repositories {
    mavenCentral()
}


publishing {
}

