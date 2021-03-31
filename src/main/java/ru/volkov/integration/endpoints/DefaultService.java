package ru.volkov.integration.endpoints;

import org.springframework.messaging.Message;

public class DefaultService {

    public void print(Message<?> message) {
        System.out.println("Printing from the default service");
    }
}
