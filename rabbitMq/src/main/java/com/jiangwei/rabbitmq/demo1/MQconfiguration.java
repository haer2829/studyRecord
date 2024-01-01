package com.jiangwei.rabbitmq.demo1;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQconfiguration {
    //声明队列
    @Bean
    public Queue queue1(){
        Queue queue = new Queue("queue1",false,false,false);
        return queue;
    }
    @Bean
    public Queue queue2(){
        Queue queue = new Queue("queue2",false,false,false);
        return queue;
    }
    @Bean
    public Queue queue3(){
        Queue queue = new Queue("queue3",false,false,false);
        return queue;
    }
    //声明交换机
    @Bean
    public Exchange exchangeTopic(){
        ExchangeBuilder e1 = ExchangeBuilder.topicExchange("e1");
        return e1.build();
    }

    //声明路由绑定关系
    @Bean
    public Binding b1(Queue queue1,Exchange exchangeTopic){
        Binding binding = BindingBuilder.bind(queue1).to(exchangeTopic).with("#.1.#").noargs();
        return binding;
    }
    @Bean
    public Binding b2(Queue queue2,Exchange exchangeTopic){
        Binding binding = BindingBuilder.bind(queue2).to(exchangeTopic).with("#.2.#").noargs();
        return binding;
    }
    @Bean
    public Binding b3(Queue queue3,Exchange exchangeTopic){
        Binding binding = BindingBuilder.bind(queue3).to(exchangeTopic).with("#.3.#").noargs();
        return binding;
    }




}
