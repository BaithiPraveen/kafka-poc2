package pbaithi.poc.branch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pbaithi.poc.branch.model.Transaction;


@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    @Value("${kafka.topic.name}")
    private String topic;

    public void send(Transaction transaction) {
        kafkaTemplate.send(topic, transaction);
    }
}
