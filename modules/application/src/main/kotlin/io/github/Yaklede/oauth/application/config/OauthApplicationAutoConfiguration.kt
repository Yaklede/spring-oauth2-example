package io.github.Yaklede.oauth.application.config

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.context.annotation.ComponentScan

@AutoConfiguration
@ComponentScan(basePackages = ["io.github.Yaklede.oauth.application"])
class OauthApplicationAutoConfiguration
