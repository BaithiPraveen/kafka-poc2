package pbaithi.poc.branch.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pabaithi.poc.base_domain.dto.TransactionDTO;
import pbaithi.poc.branch.model.Transaction;
import pbaithi.poc.branch.repository.TransactionRepo;


@Slf4j
@Service
public class KafkaConsumer {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private ModelMapper modelMapper;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(TransactionDTO transactionDTO){
        log.info("received msg from kafka .. {} ",transactionDTO);
        Transaction receivedTransaction = modelMapper.map(transactionDTO,Transaction.class);
        log.info("RECEIVED TXN DETAILS : {} ",receivedTransaction);
        repository.save(receivedTransaction);
        log.info("Transaction saved to branch DB: {}", receivedTransaction);
    }

}
