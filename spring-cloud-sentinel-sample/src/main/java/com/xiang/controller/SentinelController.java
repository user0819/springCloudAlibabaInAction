package com.xiang.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentinelController {

    @SentinelResource(value = "random", blockHandler = "myBlockHandler")
    @GetMapping("/random")
    public String random() {
        return System.currentTimeMillis() + "";
    }

    public String myBlockHandler(BlockException e) {
        return "这条路有点拥挤，要加油哦";

    }


    @GetMapping("/random2")
    public String random2() {
        return System.currentTimeMillis() + "";
    }
}
