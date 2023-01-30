package com.templates.cloudstream.entrypoint.messaging.event.dto;

import com.templates.cloudstream.entrypoint.messaging.event.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonWasCreatedEventSource implements Event {

    public static final String EVENT = "PERSON_WAS_CREATED";
    public static final String TOPIC_NAME = "template_person-was-created";

    private String id;
    private String name;
    private String documentNumber;

    @Override
    public String outputTopicName() {
        return TOPIC_NAME;
    }

    @Override
    public String getEventType() {
        return EVENT;
    }

}
