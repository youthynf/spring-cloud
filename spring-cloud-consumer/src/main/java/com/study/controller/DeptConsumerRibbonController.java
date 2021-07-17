package com.study.controller;

import com.study.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 使用Ribbon实现负载均衡:
 * Ribbon和eureka整合后，客户端可以直接通过服务名调用，不需要关注服务端口号
 */
@RestController
public class DeptConsumerRibbonController {
    // 理解：消费者不应该有service层
    // RestTemplate 供我们在这里调用就可以了，注册到spring中

    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法，简单的restful服务模板

    // 固定provider服务的请求连接
    // private static final String REST_URL_PREFIX = "http://localhost:8001";
    // 使用负载均衡Ribbon我们这里的地址应该是一个变量，通过服务名来访问
    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDER";

    @RequestMapping("/consumerRibbon/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumerRibbon/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumerRibbon/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    // 通过调用http://localhost:90/consumerRibbon/ribbon/getPort，感受ribbon负载均衡
    @RequestMapping("/consumerRibbon/ribbon/getPort")
    public String getPort() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/ribbon/getPort", String.class);
    }
}
