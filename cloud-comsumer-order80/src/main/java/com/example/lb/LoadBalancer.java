package com.example.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

public interface LoadBalancer {
    ServiceInstance choose(List<ServiceInstance> serviceInstances);
}
