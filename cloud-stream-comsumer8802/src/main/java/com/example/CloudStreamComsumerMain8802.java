package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudStreamComsumerMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(CloudStreamComsumerMain8802.class, args);
    }
}
