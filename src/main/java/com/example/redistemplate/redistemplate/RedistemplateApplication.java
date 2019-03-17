package com.example.redistemplate.redistemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class RedistemplateApplication {


    public static void main(String[] args) {
        SpringApplication.run(RedistemplateApplication.class, args);
    }

}
