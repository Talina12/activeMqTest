package com.example.webapp;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.jms.Queue;

@Configuration
public class ActiveMqConfig {

    @Bean
    public Queue queue() {
        return new ActiveMQQueue("sample.queue");
    }
}
