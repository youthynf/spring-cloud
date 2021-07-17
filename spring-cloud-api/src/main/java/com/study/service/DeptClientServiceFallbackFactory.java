package com.study.service;

import com.study.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept().setDeptno(id)
                        .setDname("id=>" + id + "没有对应的记录，客户端采用了降级的策略")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public String getPort() {
                return null;
            }
        };
    }
}
