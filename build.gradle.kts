import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.30"
}

// val compileKotlin: KotlinCompile by tasks

// compileKotlin.kotlinOptions.useIR = true

tasks {
    compileKotlin {
        kotlinOptions.useIR = true
    }
}


group = "cz.scorpionsoft.kotlin.demos"
version = 0.1

java.sourceCompatibility = JavaVersion.VERSION_11


repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
    testRuntimeOnly("org.junit.jupiter", "junit-jupiter-api", "5.7.1")
}

tasks.test {
    useJUnitPlatform()
    exclude("**/*ManualTest.class")
}

