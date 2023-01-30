package com.templates.cloudstream.dataprovider.messaging.gateway;

import com.templates.cloudstream.core.gateway.PersonEventGateway;
import com.templates.cloudstream.core.model.Person;
import com.templates.cloudstream.dataprovider.messaging.payloads.PersonWasCreatedEventSource;
import com.templates.cloudstream.dataprovider.messaging.producer.KafkaEventProducer;
import com.templates.cloudstream.dataprovider.messaging.producer.KafkaMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonEventGatewayImpl implements PersonEventGateway {

    private final KafkaEventProducer producer;

    @Override
    public void sendEventPersonWasCreated(final Person person) {
        var eventSource = PersonWasCreatedEventSource.of(person);

        producer.sendMessage(KafkaMessage.builder()
                .event(eventSource.getEvent())
                .messageKey(eventSource.getId())
                .source(eventSource)
            .build());
    }

}
