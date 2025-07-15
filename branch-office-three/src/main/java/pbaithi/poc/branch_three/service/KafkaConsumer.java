package pbaithi.poc.branch_three.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pabaithi.poc.base_domain.dto.TransactionDTO;
import pbaithi.poc.branch_three.model.Transaction;
import pbaithi.poc.branch_three.repository.TransactionRepo;

@Slf4j
@Service
public class KafkaConsumer {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void configureMapper() {
        modelMapper.typeMap(TransactionDTO.class, Transaction.class)
                .addMappings(mapper -> mapper.skip(Transaction::setBranchId));
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(TransactionDTO transactionDTO){
        log.info("received msg from kafka .. {} ",transactionDTO);
        Transaction receivedTransaction = modelMapper.map(transactionDTO,Transaction.class);
        log.info("RECEIVED TXN DETAILS : {} ",receivedTransaction);
        repository.save(receivedTransaction);
        log.info("Transaction saved to main DB: {}", receivedTransaction);
    }

}