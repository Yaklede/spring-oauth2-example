tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

dependencies {
    compileOnly("org.springframework.boot:spring-boot-autoconfigure")

    implementation(projects.modules.domain)
    implementation("org.springframework:spring-tx")
}
