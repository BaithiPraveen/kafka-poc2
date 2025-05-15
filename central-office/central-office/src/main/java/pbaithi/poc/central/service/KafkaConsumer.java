package pbaithi.poc.central.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pbaithi.poc.central.model.Transaction;
import pbaithi.poc.central.repository.TransactionRepo;

@Slf4j
@Component
public class KafkaConsumer {
    @Autowired
    private TransactionRepo repository;

    @KafkaListener(topics = "transactions", groupId = "central-group")
    public void consume(Transaction transaction) {
        log.info("consumed data from KAFKA : {} ",transaction);
        repository.save(transaction); // Save into central DB
        log.info("Transaction saved to main DB: {}", transaction);
    }
}
