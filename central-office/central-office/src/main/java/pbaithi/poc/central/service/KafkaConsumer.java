package pbaithi.poc.central.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pbaithi.poc.central.dto.TransactionDTO;
import pbaithi.poc.central.model.Transaction;
import pbaithi.poc.central.repository.TransactionRepo;

@Slf4j
@Service
public class KafkaConsumer {
    @Autowired
    private TransactionRepo repository;

    @Autowired
    private ModelMapper modelMapper;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(String message) throws JsonProcessingException {
        log.info("received msg from kafka .. {} ",message);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TransactionDTO txnDTO = objectMapper.readValue(message, TransactionDTO.class);
        Transaction receivedTransaction = modelMapper.map(txnDTO,Transaction.class);
        log.info("RECEIVED TXN DETAILS : {} ",receivedTransaction);
        repository.save(receivedTransaction);
        log.info("Transaction saved to main DB: {}", receivedTransaction);
    }

}
