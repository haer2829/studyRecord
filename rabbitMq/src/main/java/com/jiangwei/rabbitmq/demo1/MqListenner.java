package com.jiangwei.rabbitmq.demo1;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
@Slf4j
public class MqListenner {
    @RabbitListener(queues = "queue1")
    public void l1(Message message, Channel channel){
        log.info("队列queue1 接受到信息了！");
        log.info(new String(message.getBody(), StandardCharsets.UTF_8));
        log.info("队列queue1 处理完成");
    }

    @RabbitListener(queues = "queue2")
    public void l2(Message message, Channel channel){
        log.info("队列queue2 接受到信息了！");
        log.info(new String(message.getBody(), StandardCharsets.UTF_8));
        log.info("队列queue2 处理完成");
    }

    @RabbitListener(queues = "queue3")
    public void l3(Message message, Channel channel){
        log.info("队列queue3 接受到信息了！");
        log.info(new String(message.getBody(), StandardCharsets.UTF_8));
        log.info("队列queue3 处理完成");
    }
}
