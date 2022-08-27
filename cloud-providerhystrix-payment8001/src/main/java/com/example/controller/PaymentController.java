package com.example.controller;

import com.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    public String paymentInfoOK(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoOK(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoTimeout(id);
    }

    @GetMapping(value = "/payment/hystrix/circuit/{id}")
    public String paymentInfoCircuit(@PathVariable("id") Integer id) {
        return paymentService.paymentInfoCircuit(id);
    }
}
