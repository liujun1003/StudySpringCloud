package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderConsulPaymentMain8005 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderConsulPaymentMain8005.class, args);
    }
}
