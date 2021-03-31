package ru.volkov.integration.endpoints;

import org.springframework.messaging.Message;

public interface PrinterGateway {

    void print(Message<?> message);
}
