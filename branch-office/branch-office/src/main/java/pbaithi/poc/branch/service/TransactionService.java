package pbaithi.poc.branch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pbaithi.poc.branch.model.Transaction;
import pbaithi.poc.branch.repository.TransactionRepo;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private KafkaProducer producer;

    public Transaction createTransaction(Transaction txn) {
        Transaction saved = repository.save(txn);
        producer.send(saved); // Send to Kafka after saving to branch db
        return saved;
    }
}
