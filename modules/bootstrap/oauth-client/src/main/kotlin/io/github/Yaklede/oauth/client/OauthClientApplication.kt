package io.github.Yaklede.oauth.client

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OauthClientApplication

fun main(args: Array<String>) {
    runApplication<OauthClientApplication>(*args)
}
