package com.xiang.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConfigController {

    //通过下面对比可以得知：
    //Value注解的字段值只加载一次，即后续即使配置中心的值改变了，configValue也不会再变
    //但environment.getProperty("info"))却能实时获取到最新的值
    @Value(value = "${info:Hello}")
    private String configValue;


    @Resource
    private Environment environment;


    @Value(value = "${active:dev}")
    private String activeEnv;

    @GetMapping("/config")
    public String config() {
        System.out.println("configValue: " + configValue);
        System.out.println("environmentValue: " + environment.getProperty("info"));
        return configValue;
    }

    @GetMapping("/active")
    public String active() {
        System.out.println("activeEnv: " + activeEnv);
        System.out.println("environmentValue: " + environment.getProperty("active"));
        return activeEnv;
    }
}
