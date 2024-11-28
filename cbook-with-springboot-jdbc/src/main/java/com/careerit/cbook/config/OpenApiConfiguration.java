package com.careerit.cbook.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Value("${project.name:Contact Book}")
    private String projectName;

    @Value("${project.description:Contact Book Application}")
    private String projectDescription;

    @Value("${project.version:1.0.0}")
    private String version;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new io.swagger.v3.oas.models.info.Info()
                                .title(projectName)
                                .version(version)
                                .contact(new io.swagger.v3.oas.models.info.Contact().email("admin@careerit.com"))
                                .description(projectDescription));
    }
}
