package ru.volkov.integration.endpoints;

import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomSplitter {

    protected Object split(Message<?> message) {
        return new ArrayList<String>(Arrays.asList(message.getPayload().toString().split(" ")));
    }
}
