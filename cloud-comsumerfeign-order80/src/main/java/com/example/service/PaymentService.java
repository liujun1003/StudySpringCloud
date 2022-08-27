package com.example.service;

import com.example.entities.CommonResult;
import com.example.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "cloud-provider-payment")
public interface PaymentService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable(name = "id") long id);

    @GetMapping(value = "/payment/timeout")
    String getPaymentTimeout();
}
