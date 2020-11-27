package com.demo;

import com.demo.service.ElasticSearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author: gan
 * @date: 2020/11/27
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ElasticSearchService elasticSearchService = applicationContext.getBean(ElasticSearchService.class);
//        elasticSearchService.index();
        elasticSearchService.select();
    }
}
