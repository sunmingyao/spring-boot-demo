package com.example.demo.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.Optional;

/**
 * @Auther: sunmingyao
 * @Date: 2019/1/17 10 29
 * @Description:
 */
public class Listener {

    @KafkaListener(topics = {"test-topic"})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());


        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("监听kEY：" + record.key());
            System.out.println("监听到的VALUE：" + message);

        }

    }
}