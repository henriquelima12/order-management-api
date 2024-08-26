package com.example.orderapi.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String pedido) {
        amqpTemplate.convertAndSend("order-request-exchange",
                "order-request-rout-key", pedido);
    }
}
