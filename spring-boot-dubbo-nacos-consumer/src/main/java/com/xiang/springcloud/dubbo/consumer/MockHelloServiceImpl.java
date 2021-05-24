package com.xiang.springcloud.dubbo.consumer;

import com.xiang.IHelloService;

public class MockHelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String s) {
        return "暂时无法访问";
    }
}
