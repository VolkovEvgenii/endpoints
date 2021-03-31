package ru.volkov.integration.endpoints;

import org.springframework.messaging.Message;

public class NumericPrintService {

    public void print(Message<String> message) {
        System.out.println("Print numeric: " + message.getPayload());
    }
}
