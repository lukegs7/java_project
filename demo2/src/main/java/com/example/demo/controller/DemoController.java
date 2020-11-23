package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.properties.AliyunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {


    // @Autowired
    // private User user;
    @Resource(name = "user")
    private User user;

    @GetMapping("/test")
    public String getName() {
        return "Spring boot";
    }

    @GetMapping("user")
    public User user() {
        return user;
    }

    @Value("${picPath}")
    private String picPath;

    @GetMapping("/picPath")
    public String picPath() {
        return picPath;
    }

    @Autowired
    private AliyunProperties aliyunProperties;
    @GetMapping("/aliyun")
    public AliyunProperties aliyun() {
        return aliyunProperties;
    }
}
