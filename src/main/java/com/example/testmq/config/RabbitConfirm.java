package com.example.testmq.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitConfirm implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        String id=correlationData.getId();
        if(!b){
            System.out.println("发送失败+原因"+s);
        }else{
            System.out.println("“发送成功");
        }
    }
}
