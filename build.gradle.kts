plugins {
	java
	id("org.springframework.boot") version "3.4.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    runtimeOnly("org.postgresql:postgresql")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register("buildFrontend") {
    group = "build"
    dependsOn("npmInstall")
    doLast {
        exec {
            commandLine("npm", "run", "build")
            workingDir = file("frontend")
        }
        copy {
            from("frontend/dist")
            into("backend/main/resources/static")
        }
    }
}

tasks.register("npmInstall") {
    group = "build"
    doLast {
        exec {
            commandLine("npm", "install")
            workingDir = file("frontend")
        }
    }
}

tasks.named("processResources").configure {
    dependsOn("buildFrontend")
}

sourceSets {
    main {
        java.srcDirs("backend/main/java")
        resources.srcDirs("backend/main/resources")
    }
}