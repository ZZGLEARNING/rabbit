package com.example.testmq.config;


import com.example.testmq.constant.Constant;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * 配置mq config
 */
@Configuration
public class RabbitMqConfig {

    //声明rabbit 发送模板
    MessageConverter messageConverter = new Jackson2JsonMessageConverter();
    @Bean
    @ConditionalOnMissingBean
    public RabbitTemplate getRabbitTemplate(ConnectionFactory connectionFactory){
            RabbitTemplate template = new RabbitTemplate(connectionFactory);
            template.setConfirmCallback(new RabbitConfirm());
            template.setReturnCallback(new RabbitReturn());
            template.setMessageConverter(messageConverter);        return template;
    }

    //1.声明  队列
    @Bean("Queue")
    public Queue queueMessage(){return  new Queue(Constant.testQueue,true);}

    //声明"交换机(并且声明交换机的类型   三种类型)
    @Bean("topic")
    public TopicExchange exchange(){return new TopicExchange(Constant.exchengeTest);}

    //绑定交互机
    @Bean
    public Binding bindingExchange(@Qualifier("Queue") Queue queue,@Qualifier("topic") TopicExchange topic){

        return BindingBuilder.bind(queue).to(topic).with(Constant.routeTest);
    }
    //声明json 转换器
    @Bean
    public MessageConverter getconverter(ObjectMapper objectMapper){
        return new Jackson2JsonMessageConverter(objectMapper);
    }
    //声明 rabbit Mq监听器工厂
    @Bean(Constant.simpleFactory)
    public SimpleRabbitListenerContainerFactory listener(SimpleRabbitListenerContainerFactoryConfigurer configure, ConnectionFactory connectionFactory){

        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();

        //设置消费者的数量
        factory.setConcurrentConsumers(3);
        //factory.setMessageConverter();

        //设置消费者获取的最大消费量
        factory.setPrefetchCount(1024);
        configure.configure(factory,connectionFactory);
        return factory;
    }


}
