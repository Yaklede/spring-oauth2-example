package io.github.Yaklede.oauth.client.infra.config

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@AutoConfiguration
@ComponentScan(basePackages = ["io.github.Yaklede.oauth.client.infra"])
@EnableJpaRepositories
@EntityScan(basePackages = ["io.github.Yaklede.oauth.client.infra"])
class OauthClientInfraAutoConfiguration
