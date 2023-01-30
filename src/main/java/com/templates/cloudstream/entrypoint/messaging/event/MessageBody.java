package com.templates.cloudstream.entrypoint.messaging.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.templates.cloudstream.entrypoint.messaging.event.dto.PersonWasCreatedEventSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageBody {

    private String event;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    @JsonSubTypes(value = {
        @JsonSubTypes.Type(value = PersonWasCreatedEventSource.class, name = PersonWasCreatedEventSource.EVENT),
    })
    private Event source;
}
