package pbaithi.poc.branch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pbaithi.poc.branch.dto.TransactionDTO;
import pbaithi.poc.branch.model.Transaction;

@Slf4j
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    public void send(TransactionDTO transactionDTO) throws JsonProcessingException {
        log.info("sending data into KAFKA : {}",transactionDTO);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String json = objectMapper.writeValueAsString(transactionDTO);
        kafkaTemplate.send(topic, json);
        log.info("msg sent successfully..!");
    }
}
