package com.xiang.springclouddubboconsumer;

import com.xiang.IHelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference
    private IHelloService iHelloService;

    @GetMapping("/say")
    public String sayHello(){
        return iHelloService.sayHello("hello");
    }
}
