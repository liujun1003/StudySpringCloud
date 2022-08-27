package com.example.controller;

import com.example.entities.CommonResult;
import com.example.entities.Payment;
import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return paymentService.getPayment(id);
    }

    @GetMapping(value = "/comsumer/payment/timeout")
    public String getPaymentTimeout() {
        return paymentService.getPaymentTimeout();
    }
}
