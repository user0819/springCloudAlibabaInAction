package org.xiang;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@DubboComponentScan
@SpringBootApplication
public class SpringCloudDubboProviderSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDubboProviderSampleApplication.class, args);
    }

}
