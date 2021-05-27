package org.xiang.service;

import com.xiang.IHelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

@Service(cluster = "failfast", loadbalance = "roundrobin")
@org.springframework.stereotype.Service
public class HelloServiceImpl implements IHelloService {
    @Value("${dubbo.application.name}")
    private String serviceName;

    public String sayHello(String name) {
        String s = String.format("[%s]:Hello, %s", serviceName, name);
            System.out.println(s);
        return s;
    }
}
