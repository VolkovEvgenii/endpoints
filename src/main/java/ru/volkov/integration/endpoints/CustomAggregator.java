package ru.volkov.integration.endpoints;

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

import java.util.Map;

public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor {

    @Override
    protected Object aggregatePayloads(MessageGroup messageGroup, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();

        for (Message<?> eachMessage : messageGroup.getMessages()) {
            System.out.println(eachMessage.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
            sb.append(eachMessage.getPayload());
        }
        return sb.toString();
    }
}
