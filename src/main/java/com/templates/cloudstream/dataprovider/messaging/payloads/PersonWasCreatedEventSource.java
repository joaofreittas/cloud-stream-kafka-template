package com.templates.cloudstream.dataprovider.messaging.payloads;

import com.templates.cloudstream.core.model.Person;
import com.templates.cloudstream.dataprovider.messaging.producer.EventSourceProducer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonWasCreatedEventSource implements EventSourceProducer {

    public static final String EVENT = "PERSON_WAS_CREATED";
    public static final String TOPIC_NAME = "template_person-was-created";

    private String id;
    private String name;
    private String documentNumber;

    public static PersonWasCreatedEventSource of(Person person) {
        return PersonWasCreatedEventSource.builder()
            .id(person.getId())
            .name(person.getName())
            .documentNumber(person.getDocumentNumber())
            .build();
    }

    @Override
    public String getTopicName() {
        return TOPIC_NAME;
    }

    @Override
    public String getEvent() {
        return EVENT;
    }

}
