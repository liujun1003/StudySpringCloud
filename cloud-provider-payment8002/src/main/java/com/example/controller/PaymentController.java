package com.example.controller;

import com.example.entities.CommonResult;
import com.example.entities.Payment;
import com.example.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable(name = "id") long id) {
        Payment payment = paymentService.selectPaymentById(id);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功！端口：" + port, payment);
        } else {
            return new CommonResult<>(444, "查询失败！id" + id);
        }
    }

    @PostMapping(value = "/payment/create")
    public  CommonResult<Integer> addPayment(@RequestBody Payment payment) {
        int result = paymentService.insertPayment(payment);

        if (payment != null) {
            return new CommonResult<>(200, "插入成功！端口：" + port, result);
        } else {
            return new CommonResult<>(444, "插入失败！");
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("---service:" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("------instance:" + instance.getInstanceId());
            }
        }

        return discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return port;
    }

    @GetMapping(value = "/payment/timeout")
    public String getPaymentTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return port;
    }
}
