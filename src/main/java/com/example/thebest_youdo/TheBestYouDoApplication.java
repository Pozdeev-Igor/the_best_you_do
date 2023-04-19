package com.example.thebest_youdo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = {
        @Server( url = "https://the-best-you-do.osc-fr1.scalingo.io")
})
public class TheBestYouDoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheBestYouDoApplication.class, args);
    }

}
