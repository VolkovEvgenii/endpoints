package ru.volkov.integration.endpoints;

import org.springframework.messaging.Message;

public class PrintService {

    public void print(Message<?> message) {
        System.out.println(message.getPayload());
    }
}
