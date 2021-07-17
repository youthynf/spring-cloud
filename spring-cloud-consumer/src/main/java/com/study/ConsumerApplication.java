package com.study;

// 官网说明自定义Ribbon规则类主应用程序上下文的@ComponentScan中，否则被所有@RibbonClient共享，故将包独立出来
import com.myRule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient // eureka客户端
//在微服务启动的时候就能去加载我们自定义的Ribbon类
@RibbonClient(name = "SPRING-CLOUD-PROVIDER", configuration = MyRule.class)
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
