package com.example.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class SentinelTestService {

    @SentinelResource(value = "common", blockHandler = "handlerGetTestC")
    public String getTestC() {
        return "testC";
    }

    public String handlerGetTestC(BlockException e) {
        return "链路调用流控！";
    }
}
