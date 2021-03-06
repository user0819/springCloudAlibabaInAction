package com.xiang.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @GetMapping("/hello")
    public String sayHello(){
        redisTemplate.opsForValue().set("name", "XIANG");


        return "Hello," + redisTemplate.opsForValue().get("name");
    }
}
