package com.example.hospital.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final String kafkaTopic = "hospital.hospital.patient";

    @KafkaListener(topics = kafkaTopic)
    public void consumeMessage(String record) {
        System.out.println("Received message: " + record);
    }

}
