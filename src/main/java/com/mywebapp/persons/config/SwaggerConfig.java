package com.mywebapp.persons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public
class SwaggerConfig {

    public static final String TAG_PERSONS_REST_CONTROLLER = "persons-rest-controller";

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mywebapp.persons.controllers"))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag(TAG_PERSONS_REST_CONTROLLER, "Контроллер для работы с persons."));
    }
}
