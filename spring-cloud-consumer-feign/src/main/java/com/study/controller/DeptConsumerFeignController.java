package com.study.controller;

import com.study.pojo.Dept;
import com.study.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptConsumerFeignController {
    @Autowired
    private DeptClientService deptClientService = null;

    @PostMapping("/dept/add")
    public boolean add(Dept dept) {
        return this.deptClientService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return this.deptClientService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return this.deptClientService.queryAll();
    }
}
