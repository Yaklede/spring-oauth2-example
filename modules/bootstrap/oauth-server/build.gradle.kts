tasks.jar {
    enabled = false
}

tasks.bootJar {
    enabled = true
}

dependencies {
    implementation(projects.modules.domain)
    implementation(projects.modules.application)
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
    implementation("org.springframework.boot:spring-boot-starter-security")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
}
