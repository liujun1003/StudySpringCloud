package com.example.service;


public interface PaymentService  {

    String paymentInfoOK(Integer id);

    String paymentInfoTimeout(Integer id);

    String paymentInfoCircuit(Integer id);

}
