package pabaithi.poc.base_domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pabaithi.poc.base_domain.dto.TransactionDTO;

@Slf4j
@Component
public class KafkaBaseProducer {

    @Autowired
    private KafkaTemplate<String, TransactionDTO> kafkaTemplate;

    public void sender(String topicName, TransactionDTO transactionDTO){
        log.info("sending data into KAFKA : {}",transactionDTO);
        kafkaTemplate.send(topicName, transactionDTO);
        log.info("msg sent successfully..!");
    }
}
