plugins {
    id("java")
    id("application")
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

group = "com.vlatal.todo"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_19
}

application {
    mainClass.set("com.vlatal.todo.TodoApplication")
}

repositories {
    mavenCentral()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    // Spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.2.4")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // DB
    implementation("org.liquibase:liquibase-core:4.24.0")
    implementation("org.postgresql:postgresql:42.7.3")

    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok")
    implementation("org.slf4j:slf4j-api:2.0.13")
}


tasks.test {
    useJUnitPlatform()
}
