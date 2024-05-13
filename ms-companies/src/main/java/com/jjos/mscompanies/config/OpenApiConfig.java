package com.jjos.mscompanies.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Microservice Company  CRUD",
                version = "1.0.0",
                description = "This is a crud for management companies"
        )
)
public class OpenApiConfig {
}
