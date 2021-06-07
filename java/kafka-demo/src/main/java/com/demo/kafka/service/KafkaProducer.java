package com.demo.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author ShiTao.Gan
 **/
@Slf4j
@Service
public class KafkaProducer {

  @Autowired
  NewTopic topic1;
  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void sendMessage(String message) {
    ListenableFuture<SendResult<String, String>> future =
        kafkaTemplate.send(topic1.name(), message);

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

      @Override
      public void onSuccess(SendResult<String, String> result) {
        System.out.println("Sent message=[" + message +
            "] with offset=[" + result.getRecordMetadata().offset() + "]");
      }
      @Override
      public void onFailure(Throwable ex) {
        System.out.println("Unable to send message=["
            + message + "] due to : " + ex.getMessage());
      }
    });
  }
}
