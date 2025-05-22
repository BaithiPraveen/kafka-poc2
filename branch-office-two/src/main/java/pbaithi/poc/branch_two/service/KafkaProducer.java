package pbaithi.poc.branch_two.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pabaithi.poc.base_domain.dto.TransactionDTO;
import pabaithi.poc.base_domain.service.KafkaBaseProducer;

@Slf4j
@Component
public class KafkaProducer {

    @Autowired
    private KafkaBaseProducer KafkaBaseProducer;

    @Value("${kafka.topic.name}")
    private String topic;

    public void send(TransactionDTO transactionDTO){
        log.info("sending data into KAFKA : {}",transactionDTO);
        KafkaBaseProducer.sender(topic,transactionDTO);
//        kafkaTemplate.send(topic, transactionDTO);
        log.info("event send to base module .!");
    }
}
