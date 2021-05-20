package com.xiang.demo.myCondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    @ConditionOnFlag
    public BeanClass beanClass(){
        return new BeanClass();
    }
}
