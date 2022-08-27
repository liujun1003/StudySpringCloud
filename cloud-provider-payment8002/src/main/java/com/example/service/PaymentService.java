package com.example.service;

import com.example.entities.Payment;

public interface PaymentService {

    Payment selectPaymentById(long id);

    int insertPayment(Payment payment);

}
