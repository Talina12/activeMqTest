package com.example.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import jakarta.jms.Queue;

@RestController
public class MessageController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @PostMapping("/send")
    public String sendMessage( @RequestBody MessageDTO message) {
        jmsTemplate.convertAndSend(queue, message.getMessage());
        return "Message sent: " + message;
    }

    @GetMapping("/receive")
    public String receiveMessage() {
        String message = (String) jmsTemplate.receiveAndConvert(queue);
        return "Message received: " + message;
    }
}

