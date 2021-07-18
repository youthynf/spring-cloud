package com.study.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean { // @Configuration <=> spring的application.xml

    @Bean
    @LoadBalanced // Ribbon 配置负载均衡实现RestTemplate
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
