package pbaithi.poc.central.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import pbaithi.poc.central.model.Transaction;
import pbaithi.poc.central.repository.TransactionRepo;

@Component
public class KafkaConsumer {
    @Autowired
    private TransactionRepo repository;

    @KafkaListener(topics = "transactions", groupId = "central-group")
    public void consume(Transaction transaction) {
        repository.save(transaction); // Save into central DB
    }
}
