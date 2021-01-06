package me.lukegs7.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import me.lukegs7.springcloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info("****result:" + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    // @HystrixCommand(fallbackMethod = "paymentInfoTimeoutFallbackMethod",commandProperties = {
    //         @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
    // })
    @HystrixCommand
    public String paymengInfoTimeout(@PathVariable("id") Integer id) {
        int x = 10 / 0;
        String result = paymentHystrixService.paymentInfoTimeout(id);
        log.info("****result:" + result);
        return result;
    }

    public String paymentInfoTimeoutFallbackMethod(Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10s后再试或自己运行出错请检查";
    }

    public String paymentGlobalFallback() {
        return "全局异常，请稍后重试";
    }
}
