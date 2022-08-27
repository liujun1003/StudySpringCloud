package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudComsumerConsulOrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudComsumerConsulOrderMain80.class, args);
    }
}
