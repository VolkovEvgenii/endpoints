package ru.volkov.integration.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.Collection;

public class CustomRouter extends AbstractMessageRouter {

    private MessageChannel intChannel;
    private MessageChannel stringChannel;

    @Autowired
    public CustomRouter(
            @Qualifier("intChannel") MessageChannel intChannel,
            @Qualifier("stringChannel") MessageChannel stringChannel) {
        this.intChannel = intChannel;
        this.stringChannel = stringChannel;
    }

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Collection<MessageChannel> targetChannel =new ArrayList<>();

        if (message.getPayload().getClass().equals(Integer.class)) {
            targetChannel.add(intChannel);
        } else if (message.getPayload().getClass().equals(String.class)) {
            targetChannel.add(stringChannel);
        }

        return targetChannel;
    }
}
