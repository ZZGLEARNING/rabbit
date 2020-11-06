package com.example.testmq.listener;

import com.example.testmq.constant.Constant;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

//初始化加载mq监听器

@Component
public class RabbitListenerFactory {


    //channel  rabbit中的渠道

    //@PAYlOAD 测试消息转换格式  @Header  mq中的头信息属性  properties 中content_type 设置内容的字符类型
    //设置监听的队列  并绑定工厂
    @RabbitListener(queues = Constant.testQueue,containerFactory = Constant.simpleFactory)
    public void rabbitListener(@Payload String maMessage, @Headers Map<String,Object> header, Channel channel){

        //
        System.out.println("消费的消息"+maMessage);

        //huoqu develievey  id'  进行消息的手动确认
        Long id= (Long) header.get(AmqpHeaders.DELIVERY_TAG);

        try {
            channel.basicAck(id,false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
