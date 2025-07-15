package pbaithi.poc.central.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pbaithi.poc.central.model.Transaction;
import pbaithi.poc.central.repository.TransactionRepo;

import java.util.List;

@Slf4j
@Service
public class TransactionService {
    @Autowired
    private TransactionRepo repository;

    public List<Transaction> getAllTransactions() {
        log.info("Fetching all transactions");
        return repository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        log.info("Fetching transaction with ID: {}", id);
        return repository.findById(id).orElse(null);
    }   




}
