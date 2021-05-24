package com.xiang;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class MyMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyMainApplication.class,args);
    }
}
