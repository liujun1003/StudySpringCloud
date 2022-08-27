package com.example.service.impl;

import cn.hutool.core.util.IdUtil;
import com.example.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    public String paymentInfoOK(Integer id)
    {
        return "线程池:"+Thread.currentThread().getName()+"paymentInfoOK,id: "+id+"\t"+"O(∩_∩)O";
    }

    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfoTimeout(Integer id)
    {
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池:"+Thread.currentThread().getName()+"paymentInfoTimeout,id: "+id+"\t"+"O(∩_∩)O，耗费3秒";
    }
    public String paymentInfoTimeoutHandler(Integer id) {
        return "线程池:"+Thread.currentThread().getName()+"超时或出现错误,id: "+id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfoCircuitFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
    })
    public String paymentInfoCircuit(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id不能为负数！");
        }

        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNum;
    }
    public String paymentInfoCircuitFallback(Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }


}
