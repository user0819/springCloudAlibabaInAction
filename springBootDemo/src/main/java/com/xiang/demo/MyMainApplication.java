package com.xiang.demo;

import com.xiang.demo.component.FirstClass;
import com.xiang.demo.component.SecondClass;
import com.xiang.demo.mySelector.MyEnableAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MyEnableAutoConfig
public class MyMainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyMainApplication.class, args);
        FirstClass fc = applicationContext.getBean(FirstClass.class);
        SecondClass sc = applicationContext.getBean(SecondClass.class);
        System.out.println(fc);
        System.out.println(sc);
    }
}

