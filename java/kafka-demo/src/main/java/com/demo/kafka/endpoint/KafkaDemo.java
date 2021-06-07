package com.demo.kafka.endpoint;

import com.demo.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ShiTao.Gan
 **/
@RestController
public class KafkaDemo {

  @Autowired
  KafkaProducer kafkaProducer;

  @GetMapping("/send")
  public void sendMessage(@RequestParam("message") String message) {
    kafkaProducer.sendMessage(message);
  }
}
