package pbaithi.poc.branch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pabaithi.poc.base_domain.dto.TransactionDTO;
import pbaithi.poc.branch.model.Transaction;
import pbaithi.poc.branch.repository.TransactionRepo;
import java.util.List;

@Slf4j
@Service
public class TransactionService {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private KafkaProducer producer;

    @Autowired
    private ModelMapper modelMapper;

    public Transaction createTransaction(Transaction txn) throws JsonProcessingException {
        log.info("sending data into emargency db : {}", txn.getType());
        Transaction saved = repository.save(txn);
        log.info("successfully inserted data : {} ", saved);
        TransactionDTO txnDTO = modelMapper.map(saved, TransactionDTO.class);
        producer.send(txnDTO);
        log.info("successfully inserted in main db ");
        return saved;
    }

    public Transaction getTransactionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
}
