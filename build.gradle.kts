import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
}

group = "me.tg"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    // this is temp. will find gson work around here
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", "2.13.0")

    implementation("com.google.code.gson", "gson", "2.8.9")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

