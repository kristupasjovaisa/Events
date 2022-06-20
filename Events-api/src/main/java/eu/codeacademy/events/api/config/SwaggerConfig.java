package eu.codeacademy.events.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("eu.codeacademy.events.api"))
                .build();
    }

    private static ApiInfo getInfo() {
        return new ApiInfo(
                "Events RestFull Api Documentation",
                "This is simple documentation using swagger and springFox",
                "0.0.1",
                "Events term URL",
                new Contact("Kristupas Jovaiša", "www.codeacademy.eu", "kristupas.jovaisa03@gmail.com"),
                "Events licence",
                "Licence URL",
                Collections.emptyList()
        );
    }
}