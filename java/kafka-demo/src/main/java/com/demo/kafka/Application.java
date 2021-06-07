package com.demo.kafka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author ShiTao.Gan
 **/
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class).run(args);
  }
}
