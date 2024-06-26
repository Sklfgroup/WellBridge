package com.wellbridge.wellbridge.swagger;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private SecurityScheme createAPIKeySchema(){
        return  new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().addSecurityItem(new SecurityRequirement()
                .addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeySchema()))
                .info(new Info().title("MY REST API")
                        .description("Api for travel together projet.")
                        .version("1.0").contact(new Contact().name("djoumessi franklinarnole")
                                .email("franklin.djoumessi576@gmail.com").url("sdjsd.com"))
                        .license(new License().name("LIcence of APi")
                                .url("API licence URL")));
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Wellbridge API")
                        .version("1.0")
                        .description("API documentation for Wellbridge application"));
    }
}