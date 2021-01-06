package me.lukegs7.springcloud;

import me.lukegs7.myrule.MySelfRule;
import me.lukegs7.springcloud.lb.impl.MyLB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "CLOUD-PAYMENT-SERVICE", configuration = MyLB.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
