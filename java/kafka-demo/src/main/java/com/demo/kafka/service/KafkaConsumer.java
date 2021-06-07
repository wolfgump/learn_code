package com.demo.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ShiTao.Gan
 **/
@Component
public class KafkaConsumer {
  @KafkaListener(topics = "kafka-demo", groupId = "demo-consumer")
  public void listenGroupFoo(String message) {
    System.out.println("Received Message in group foo: " + message);
  }
}
