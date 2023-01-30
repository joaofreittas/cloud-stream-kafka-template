package com.templates.cloudstream.dataprovider.messaging.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.templates.cloudstream.dataprovider.messaging.exception.KafkaEventProducerException;
import com.templates.cloudstream.dataprovider.messaging.util.HeaderUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaEventProducer {

    private final ObjectMapper mapper;
    private final StreamBridge streamBridge;

    public void sendMessage(KafkaMessage kafkaMessage) {
        validateKafkaMessage(kafkaMessage);
        String message = null;
        try{
            message = mapper.writeValueAsString(kafkaMessage);
            final var source = kafkaMessage.getSource();
            final var messageHeaders = HeaderUtil.buildHeadersFromMessage(kafkaMessage);

            streamBridge.send(source.getTopicName(), MessageProducer.toMessage(message, messageHeaders));
        } catch (Exception e) {
            log.error("[KafkaEventProducer] Error trying to send topic {} - message [{}]]", kafkaMessage.getSource().getTopicName(), kafkaMessage);
            throw new KafkaEventProducerException(String.format("Erro ao enviar ao tópico %s", kafkaMessage.getSource().getTopicName()), e);
        }
    }

    private void validateKafkaMessage(KafkaMessage kafkaMessage) {
        if (Objects.isNull(kafkaMessage)
                || Objects.isNull(kafkaMessage.getSource())
                || Objects.isNull(kafkaMessage.getEvent())) {
            log.error("[KafkaEventProducer] kafkaMessage is invalid");
            throw new KafkaEventProducerException("kafkaMessage is invalid");
        }
    }
}
