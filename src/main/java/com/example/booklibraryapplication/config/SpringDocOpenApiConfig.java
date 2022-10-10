package com.example.booklibraryapplication.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
@RequiredArgsConstructor
public class SpringDocOpenApiConfig {

    @Value("${server.base.path}")
    private String serverBasePath;

    @Bean
    public OpenAPI api() {

        return new OpenAPI()
            .info(new Info()
                    .version("v1")
                    .description("Sample book library application")
                    .title("Book Library APIs"))
            .servers(
                    List.of(
                            new Server()
                                    .url(serverBasePath)
                                    .description("DEV")
                    )
            );
    }

}
