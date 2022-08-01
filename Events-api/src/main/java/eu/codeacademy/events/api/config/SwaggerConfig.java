package eu.codeacademy.events.api.config;

import eu.codeacademy.events.commons.swagger.annotation.OpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(OpenApi.class))
                .build()
                .securitySchemes(List.of(jwtAuthScheme()))
                .securityContexts(List.of(jwtAuthContext()));
    }

//    private SecurityContext jwtAuthContext() {
//        return SecurityContext.builder()
//                .securityReferences(jwtAuthReference())
//                .build();
//    }

    private List<SecurityReference> jwtAuthReference() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
    }

    private SecurityScheme jwtAuthScheme() {
        return new ApiKey("JWT", HttpHeaders.AUTHORIZATION,"header");
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