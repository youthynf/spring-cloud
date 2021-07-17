package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonTestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/ribbon/getPort")
    public String getPort() {
        System.out.println(port);
        return "我的端口号是：" + port;
    }
}
