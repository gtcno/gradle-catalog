plugins {
    `maven-publish`
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin{
    plugins{
        create("kotlin-app") {
            id = "no.nav.dagpenger"
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

