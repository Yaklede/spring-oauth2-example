plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.5.7" apply false
	id("io.spring.dependency-management") version "1.1.7" apply false
	kotlin("plugin.jpa") version "1.9.25"
}

allprojects {
	apply(plugin = "org.jetbrains.kotlin.jvm")

	group = "io.github.Yaklede"
	version = "0.0.1-SNAPSHOT"
	description = "oauth2 example"

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(17)
		}
	}

	kotlin {
		compilerOptions {
			freeCompilerArgs.addAll("-Xjsr305=strict")
		}
	}

	dependencies {
		implementation("org.jetbrains.kotlin:kotlin-reflect")

		// jackson
		implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
		implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.16.1")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

repositories {
	mavenCentral()
}

// bootstrap
project(":modules:bootstrap") {
	subprojects {
		apply(plugin = "org.springframework.boot")
		apply(plugin = "io.spring.dependency-management")
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	}
}

// application
project(":modules:application") {
	apply(plugin = "org.springframework.boot")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.jetbrains.kotlin.plugin.spring")
}

// domain
project(":modules:domain") {
	// POJO
}

// infra
project(":modules:infrastructure") {
	subprojects {
		apply(plugin = "org.springframework.boot")
		apply(plugin = "io.spring.dependency-management")
		apply(plugin = "org.jetbrains.kotlin.plugin.spring")
	}
}
