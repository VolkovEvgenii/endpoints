package ru.volkov.integration.endpoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:integration_context.xml")
public class EndpointsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndpointsApplication.class, args);
    }

}
