package com.example.EasyBlog.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI().info(new Info()
                .title("EasyBlog API")
                .description("API for managing a blog")
                .version("0.0.1")
                .contact(new Contact()
                        .name("Java 11 Gruppo 2")
                        .url("https://www.develhope.co/"))
        ).externalDocs(new ExternalDocumentation()
                .description("EasyBlog Github")
                .url("https://github.com/Federico-Z96/EasyBlog")
        );
    }
}
