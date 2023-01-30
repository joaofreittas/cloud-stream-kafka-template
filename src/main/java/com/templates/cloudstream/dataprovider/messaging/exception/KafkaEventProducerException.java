package com.templates.cloudstream.dataprovider.messaging.exception;

import jakarta.validation.ValidationException;

public class KafkaEventProducerException extends ValidationException {

    public KafkaEventProducerException(final String message) {
        super(message);
    }

    public KafkaEventProducerException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
