package com.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.service.SentinelTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SentinelTestController {

    @Autowired
    private SentinelTestService sentinelTestService;

    @GetMapping(value = "/testA")
    public String getTestA() {
        return "testA" + sentinelTestService.getTestC();
    }

    @GetMapping(value = "/testB")
    public String getTestB() {
        System.out.println(Thread.currentThread().getName());
        return "testB" + sentinelTestService.getTestC();
    }

    @GetMapping(value = "/testD")
    public String getTestD() {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        int a = 10 / 0;
        System.out.println(Thread.currentThread().getName());
        return "testD" + sentinelTestService.getTestC();
    }
}
