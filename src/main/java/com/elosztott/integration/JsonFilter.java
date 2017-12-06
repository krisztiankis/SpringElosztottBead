package com.elosztott.integration;

import java.io.File;

import com.elosztott.model.User;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

public class JsonFilter implements MessageSelector {

    public boolean accept(Message<?> message) {
        if (message.getPayload() instanceof File
                && !((File) message.getPayload()).getName().endsWith(".json")) {
            return false;
        }

        return true;
    }

}
