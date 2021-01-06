package me.lukegs7.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "____paymentfallbackservice fall back-paymentInfoOk wuwuwu";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "____paymentfallbackservice fall back-paymentInfoTimeout Wuwuwu ";
    }
}
