package com.example.service;

import com.example.dao.PaymentDao;
import com.example.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PaymentService {

    Payment selectPaymentById(long id);

    int insertPayment(Payment payment);

}
