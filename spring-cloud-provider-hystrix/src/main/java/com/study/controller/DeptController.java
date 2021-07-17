package com.study.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.pojo.Dept;
import com.study.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        System.out.println(dept);
        if(dept == null) {
            throw new RuntimeException("id => " + id + "，不存在该用户，或者信息无法找到");
        }
        return dept;
    }

    // 备选方案
    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("id=>" + id + "没有对应的信息，null--@Hystrix").setDb_source("no this database in MySQL");
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {
        return deptService.queryAll();
    }
}
