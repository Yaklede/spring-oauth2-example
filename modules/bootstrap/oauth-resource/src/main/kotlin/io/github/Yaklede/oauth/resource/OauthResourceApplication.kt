package io.github.Yaklede.oauth.resource

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OauthResourceApplication

fun main(args: Array<String>) {
    runApplication<OauthResourceApplication>(*args)
}
