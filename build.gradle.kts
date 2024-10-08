plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(group = "org.seleniumhq.selenium", name = "selenium-java", version = "4.23.0")
}

tasks.test {
    useJUnitPlatform()
}