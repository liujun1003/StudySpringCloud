package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceFallback implements PaymentService{
    @Override
    public String paymentInfoOK(Integer id) {
        return "-----PaymentServiceFallback fallback paymentInfoOK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-----PaymentServiceFallback fallback paymentInfoTimeout ,o(╥﹏╥)o";
    }
}
