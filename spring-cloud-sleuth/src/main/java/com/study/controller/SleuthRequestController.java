package com.study.controller;

import com.study.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SleuthRequestController {
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法，简单的restful服务模板

    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PROVIDER";

    @RequestMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }
}
