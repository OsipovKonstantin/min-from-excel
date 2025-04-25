package com.minfromexcel.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("minfromexcel-api")
                .pathsToMatch("/api/**") // лучше ограничить путь
                .packagesToScan("com.minfromexcel.controller")
                .build();
    }
}
