package com.example.testmq.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitReturn implements RabbitTemplate.ReturnCallback {
    //信息内容  返回码，文本 ，交换机，rooutkey
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("fasongshibai ");
    }
}
