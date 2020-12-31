package me.lukegs7.springcloud.service;

import me.lukegs7.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
