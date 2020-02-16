package com.r8me.authtools.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Bean(name = "authtoolsRestTemplate")
    public RestTemplate authtoolsRestTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setConnectTimeout(Duration.of(1, ChronoUnit.SECONDS));

        final var build = restTemplateBuilder.build();
        build.setInterceptors(List.of(new PerfRequestInterceptor()));
        return build;
    }
}
