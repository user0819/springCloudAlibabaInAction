package com.xiang;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {

    @Reference(url ="dubbo://172.27.20.68:20880/com.xiang.IHelloService")
    private IHelloService helloService;
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }

    @Bean
    public ApplicationRunner runner(){
        return args -> System.out.println(helloService.sayHello("XIANG"));
    }
}
