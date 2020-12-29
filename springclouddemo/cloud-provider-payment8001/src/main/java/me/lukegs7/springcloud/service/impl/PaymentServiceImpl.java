package me.lukegs7.springcloud.service.impl;

import me.lukegs7.springcloud.dao.PaymentDao;
import me.lukegs7.springcloud.entities.Payment;
import me.lukegs7.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
