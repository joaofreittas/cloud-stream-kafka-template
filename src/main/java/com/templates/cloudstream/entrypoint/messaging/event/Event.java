package com.templates.cloudstream.entrypoint.messaging.event;

public interface Event {

    String outputTopicName();
    String getEventType();

}
