package pbaithi.poc.branch.service;

import org.springframework.beans.factory.annotation.Value;
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

    @Value("${branch-code}")
    private String branchCode;

    public void createTransaction(Transaction txn){
//        log.info("sending data into branch db : {}", txn.getType());
//        Transaction saved = repository.save(txn);
//        log.info("successfully inserted data into branch db: {} ", saved);

        txn.setBranchCode(branchCode);
        TransactionDTO txnDTO = modelMapper.map(txn, TransactionDTO.class);
        producer.send(txnDTO);
        log.info("successfully sent to KAFKA Service...! ");
        return;
    }

    public Transaction getTransactionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }
}
