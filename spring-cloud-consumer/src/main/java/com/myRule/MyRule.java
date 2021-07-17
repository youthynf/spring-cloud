package com.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {
    // 重新指定负载均衡策略
    @Bean
    public IRule myRibbonIRule() {
        // return new RandomRule(); // 默认使用的是轮询，这里使用随机策略
        return new MyRandomRule(); // 这里使用我们自定义的指定次数的轮询策略
    }
}
