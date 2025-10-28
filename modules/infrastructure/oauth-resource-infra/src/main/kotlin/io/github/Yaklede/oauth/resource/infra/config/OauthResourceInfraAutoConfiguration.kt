package io.github.Yaklede.oauth.resource.infra.config

import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@AutoConfiguration
@EnableJpaRepositories
@EntityScan(basePackages = ["io.github.Yaklede.oauth.resource.infra"])
@ComponentScan(basePackages = ["io.github.Yaklede.oauth.resource.infra"])
class OauthResourceInfraAutoConfiguration
