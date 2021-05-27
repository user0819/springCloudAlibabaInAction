package com.xiang;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlowRuleDemo {
    private static void doSomething(){
        try(Entry doSomething = SphU.entry("doSomething")){
            System.out.println("hello world " + System.currentTimeMillis() );
        }catch (BlockException e){
            //todoSomething
        }
    }

    private static void doSomething2(){
        if(SphO.entry("resourceName")){
            try {
                System.out.println("hello world2 " + System.currentTimeMillis() );
            } finally {
                SphO.exit();
            }
        }
    }

    private static void initRule(){
        FlowRule rule = new FlowRule();
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rule.setResource("doSomething");

        FlowRule rule2 = new FlowRule();
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(20);
        rule2.setResource("doSomething");


        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule);
        rules.add(rule2);
        FlowRuleManager.loadRules(rules);
    }
    public static void main(String[] args) {
        initRule();
        while(true){
            doSomething2();
        }
    }
}
