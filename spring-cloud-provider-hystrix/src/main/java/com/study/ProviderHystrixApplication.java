package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

// 启动类
@SpringBootApplication
@EnableEurekaClient // 在服务启动之后自动注册到eureka
@EnableDiscoveryClient // 服务发现
@EnableCircuitBreaker // 添加对熔断的支持
public class ProviderHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrixApplication.class, args);
    }
}