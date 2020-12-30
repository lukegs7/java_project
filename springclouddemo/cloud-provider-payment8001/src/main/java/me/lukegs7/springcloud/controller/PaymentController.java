package me.lukegs7.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import me.lukegs7.springcloud.entities.CommonResult;
import me.lukegs7.springcloud.entities.Payment;
import me.lukegs7.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    /**
     * 使用postman请求：
     * http://localhost:8001/payment/create?serial=gggg
     * @param payment
     * @return
     */
    @PostMapping(value="/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("***插入结果***" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        } else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果*****" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        } else {
            return new CommonResult(444, "没有对应的记录，查询ID" + id, null);
        }
    }
}
