package pbaithi.poc.branch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pbaithi.poc.branch.model.Transaction;
import pbaithi.poc.branch.repository.TransactionRepo;

@Slf4j
@Service
public class TransactionService {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private KafkaProducer producer;

    public Transaction createTransaction(Transaction txn) {
        log.info("sending data into emargency db : {}",txn.getType());
        Transaction saved = repository.save(txn);
        log.info("succefully inserted data : {} ",saved);
        producer.send(saved); // Send to Kafka after saving to branch db
        log.info("succefully inserted in main db ");
        return saved;
    }
}
