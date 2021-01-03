package me.lukegs7.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.lukegs7.springcloud.entities.CommonResult;
import me.lukegs7.springcloud.entities.Payment;
import me.lukegs7.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentTimeout() {
        // openfeign+ribbon 客户端一般默认等1s
        return paymentFeignService.paymentFeignTimeout();
    }
}
