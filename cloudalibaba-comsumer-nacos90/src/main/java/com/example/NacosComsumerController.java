package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class NacosComsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.provider-nacos}")
    private String serviceUrl;

    @GetMapping(value = "/comsumer/nacos/client/info")
    public String getNacosClientInfo() {
        return restTemplate.getForObject(serviceUrl + "/nacos/client/info", String.class);
    }
}
