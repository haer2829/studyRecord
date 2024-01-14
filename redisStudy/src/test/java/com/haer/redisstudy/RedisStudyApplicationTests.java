package com.haer.redisstudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class RedisStudyApplicationTests {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 字符串操作
     */
    @Test
    void contextLoads() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","zhangsan",300000, TimeUnit.SECONDS);
        valueOperations.set("age",13,300000, TimeUnit.SECONDS);
        String name = (String) valueOperations.get("name");

    }

    /**
     * list
     */
    @Test
    void list() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","zhangsan");
        valueOperations.set("age",13);


    }

    /**
     * set
     */
    @Test
    void set() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","zhangsan");
        valueOperations.set("age",13);


    }



}
