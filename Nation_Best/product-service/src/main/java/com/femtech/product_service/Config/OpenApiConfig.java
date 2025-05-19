package com.femtech.product_service.Config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "FemTech",
                        email = "gbadamosifemi1111@gmail.com"

                ),
                description = "NationBest ProductService created by@femtech",
                title = "NationBest OpenApi specification - Femtech",
                version = "1.0",
                license = @License(
                        name = "Licence name"

                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),

        }
)

public class OpenApiConfig {
}
