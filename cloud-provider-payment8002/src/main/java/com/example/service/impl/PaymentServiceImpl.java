package com.example.service.impl;

import com.example.dao.PaymentDao;
import com.example.entities.Payment;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public Payment selectPaymentById(long id) {
        return paymentDao.selectPaymentById(id);
    }

    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }
}
