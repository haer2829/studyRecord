package com.haer.mybatisstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haer.mybatisstudy.mapper")
public class MybatisStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisStudyApplication.class, args);
    }

}
