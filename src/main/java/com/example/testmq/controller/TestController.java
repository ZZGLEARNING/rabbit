package com.example.testmq.controller;


import com.example.testmq.constant.Constant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

 @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public void gethello(){

        rabbitTemplate.convertAndSend(Constant.exchengeTest,"topic.test","HELLO RABBITMQ");
        System.out.println("hello");
    }
}
