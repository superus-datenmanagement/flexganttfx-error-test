plugins {
    application
    kotlin("jvm") version "1.6.10"
    id("org.openjfx.javafxplugin") version "0.0.11"
}

group = "org.example"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.superus.javafx.flexgantt.FlexganttApplicationKt")
}

repositories {
    mavenCentral()
    maven(url = "http://www.license4j.com/maven/") {
        isAllowInsecureProtocol = true
    }
}

dependencies {
    implementation(project.fileTree("lib") {
        include("*.jar")
    })
    implementation(group = "org.controlsfx", name = "controlsfx", version = "11.1.0")
}

javafx {
    version = "11.0.2"
    modules("javafx.base", "javafx.controls", "javafx.fxml", "javafx.web", "javafx.swing")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
