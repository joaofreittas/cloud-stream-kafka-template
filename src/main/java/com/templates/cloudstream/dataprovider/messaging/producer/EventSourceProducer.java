package com.templates.cloudstream.dataprovider.messaging.producer;


public interface EventSourceProducer {
    String getTopicName();
    String getEvent();

}
