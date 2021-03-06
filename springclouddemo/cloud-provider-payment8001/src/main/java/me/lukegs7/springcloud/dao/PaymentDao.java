package me.lukegs7.springcloud.dao;


import me.lukegs7.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
