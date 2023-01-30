package com.templates.cloudstream.dataprovider.messaging.producer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KafkaMessage {
    private String event;
    private String messageKey;
    private EventSourceProducer source;

}
