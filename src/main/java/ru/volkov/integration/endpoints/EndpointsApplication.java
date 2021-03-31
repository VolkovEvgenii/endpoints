package ru.volkov.integration.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@ImportResource("classpath:integration_context.xml")
public class EndpointsApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(EndpointsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                Message<?> message = MessageBuilder.withPayload(i).build();
                this.gateway.print(message);
            } else {
                Message<?> message = MessageBuilder.withPayload("String " + i).build();
                this.gateway.print(message);
            }
        }
    }

}
