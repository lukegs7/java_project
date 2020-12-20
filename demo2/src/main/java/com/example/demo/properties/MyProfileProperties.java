package com.example.demo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Component
@ConfigurationProperties(prefix = "my-profile")
@Data
public class MyProfileProperties {
    String name;
    int age;
}
