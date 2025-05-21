package pbaithi.poc.central.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pabaithi.poc.base_domain.dto.TransactionDTO;
import pbaithi.poc.central.model.Transaction;
import pbaithi.poc.central.repository.TransactionRepo;

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
                .addMappings(mapper -> mapper.skip(Transaction::setId));
    }

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(TransactionDTO transactionDTO) throws JsonProcessingException {
        log.info("received msg from kafka .. {} ",transactionDTO);
        Transaction receivedTransaction = modelMapper.map(transactionDTO,Transaction.class);
        log.info("RECEIVED TXN DETAILS : {} ",receivedTransaction);
        repository.save(receivedTransaction);
        log.info("Transaction saved to main DB: {}", receivedTransaction);
    }

}
