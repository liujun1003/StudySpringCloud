package com.example;

import com.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "cloud-provider-payment", configuration = MyRule.class)
public class CloudComsumerOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudComsumerOrderMain80.class, args);
    }
}
