package me.lukegs7.springclou.controller;

import lombok.extern.slf4j.Slf4j;
import me.lukegs7.springclou.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymengInfoOk(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoOk(id);
        log.info("****result:" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymengInfoTimeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfoTimeout(id);
        log.info("****result:" + result);
        return result;
    }

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*** result: " + result);
        return result;
    }
}
