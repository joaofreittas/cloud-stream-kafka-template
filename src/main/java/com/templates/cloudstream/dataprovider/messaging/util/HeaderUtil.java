package com.templates.cloudstream.dataprovider.messaging.util;

import com.templates.cloudstream.dataprovider.messaging.producer.KafkaMessage;
import org.slf4j.MDC;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

public final class HeaderUtil {

    public static final String CORRELATION_ID_HEADER = "correlationId";
    public static final String EVENT_NAME_HEADER = "eventName";
    public static final String EVENT_ID_HEADER = "eventId";

    private HeaderUtil() {
    }

    public static MessageHeaders buildHeadersFromMessage(KafkaMessage kafkaMessage) {
        return new MessageHeaders(buildDefaultHeaders(kafkaMessage));
    }

    private static Map<String, Object> buildDefaultHeaders(KafkaMessage kafkaMessage) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(CORRELATION_ID_HEADER, getCorrelationId());
        headers.put(EVENT_NAME_HEADER, kafkaMessage.getEvent());
        headers.put(EVENT_ID_HEADER, UUID.randomUUID().toString());

        if (isNotBlank(kafkaMessage.getMessageKey())) {
            headers.put(KafkaHeaders.KEY, kafkaMessage.getMessageKey());
        }

        return headers;
    }

    private static String getCorrelationId() {
        return Objects.nonNull(MDC.get("correlation_id")) ? MDC.get("correlation_id") : UUID.randomUUID().toString();
    }
}
