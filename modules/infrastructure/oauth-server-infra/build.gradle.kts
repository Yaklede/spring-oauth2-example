tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

plugins {
    kotlin("kapt")
    kotlin("plugin.jpa")
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}
dependencies {
    implementation(projects.modules.domain)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
    implementation("org.mariadb.jdbc:mariadb-java-client")
}
