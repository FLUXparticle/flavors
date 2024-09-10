plugins {
    kotlin("jvm") version "1.9.20"
    id("maven-publish")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

publishing {
    publications {
        create<MavenPublication>("flavors") {
            from(components["java"])
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation("com.android.tools.build:gradle:8.2.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

kotlin {
    jvmToolchain(17)
}
tasks.test {
    useJUnitPlatform()
}
