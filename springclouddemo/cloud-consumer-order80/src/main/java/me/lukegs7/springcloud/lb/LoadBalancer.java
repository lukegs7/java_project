package me.lukegs7.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;


public interface LoadBalancer {
    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
