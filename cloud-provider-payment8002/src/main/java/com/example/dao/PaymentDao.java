package com.example.dao;

import com.example.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Payment selectPaymentById(long id);

    int insertPayment(Payment payment);
}
