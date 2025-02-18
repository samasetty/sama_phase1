plugins {
    id("java")
    id("application")
}

group = "decaf"
version = "0.1.0-SNAPSHOT"

// Our build server uses Java 17
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Ensure the ANTLR runtime is on the classpath
    implementation("org.antlr:antlr4-runtime:4.13.0")

    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    // Make sure to change this class if the entry point of your program changes
    mainClass.set("decaf.DecafCompiler")
}

tasks.test {
    useJUnitPlatform()
}
