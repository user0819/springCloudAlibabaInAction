package com.xiang;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class DegradeRuleDemo {
    private static void doSomething(){
        try(Entry doSomething = SphU.entry("doSomething")){
            System.out.println("hello world " + System.currentTimeMillis() );
        }catch (BlockException e){
            //todoSomething
        }
    }

    private static void doSomething2(){
        if(SphO.entry("KEY")){
            try {
                System.out.println("hello world2 " + System.currentTimeMillis() );
            } finally {
                SphO.exit();
            }
        }
    }

    private static void initRule(){
        DegradeRule rule = new DegradeRule();
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule.setCount(20);
        rule.setResource("doSomething");

        DegradeRule rule2 = new DegradeRule();
        rule2.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        rule2.setCount(20);
        rule2.setResource("KEY");


        List<DegradeRule> rules = new ArrayList<>();
        rules.add(rule);
        rules.add(rule2);
        DegradeRuleManager.loadRules(rules);
    }
    public static void main(String[] args) {
        initRule();
        while(true){
            doSomething2();
        }
    }
}
