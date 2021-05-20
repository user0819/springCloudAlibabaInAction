package com.xiang.demo.myCondition;

import com.xiang.demo.DemoApplication;
import com.xiang.demo.component.FirstClass;
import com.xiang.demo.mySelector.MyEnableAutoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MyEnableAutoConfig
public class MyConditionApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MyConditionApplication.class, args);
        BeanClass beanClass = applicationContext.getBean(BeanClass.class);
        System.out.println(beanClass);
    }
}

