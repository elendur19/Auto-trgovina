package hr.fer.ris.autotrgovina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;

import static io.swagger.models.auth.In.HEADER;
import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    private static final String TITLE = "Car shop REST API";
    private static final String DESCRIPTION = "Rest api for Car shop";

    @Bean
    public Docket projectApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //.securitySchemes(singletonList(new ApiKey(JWT, AUTHORIZATION, HEADER.name())))
//                .securityContexts(singletonList(
//                        SecurityContext.builder()
//                                .securityReferences(
//                                        singletonList(SecurityReference.builder()
//                                                .reference(JWT)
//                                                .scopes(new AuthorizationScope[0])
//                                                .build()
//                                        )
//                                )
//                                .build())
//                )
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .extensions(Collections.emptyList())
                .build();
    }
}
