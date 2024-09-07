package com.example.activemq;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActiveMqBrokerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ActiveMqBrokerApplication.class, args);
    }

    @Bean
    public BrokerService brokerService() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.setPersistent(false); // Non-persistent for simplicity
        brokerService.start();
        return brokerService;
    }
}
