package com.templates.cloudstream.entrypoint.messaging;

import com.templates.cloudstream.entrypoint.messaging.event.MessageBody;
import com.templates.cloudstream.entrypoint.messaging.event.dto.PersonWasCreatedEventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonWasCreatedListener {

    @Bean
    Consumer<Message<MessageBody>> personWasCreated() {
        return message -> {
            try {
                process(message.getPayload());
            } catch (RuntimeException exception) {
                log.error("[person-was-created-listener] :: message processing error: {} ", exception.getMessage());
            }
        };
    }

    private void process(final MessageBody messageBody) {
        var eventPayload = (PersonWasCreatedEventSource) messageBody.getSource();
        log.info("[person-was-created-listener] :: event received: {} ", eventPayload);
    }

}
