package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.properties.AliyunProperties;
import com.example.demo.properties.MyProfileProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@EnableConfigurationProperties(MyProfileProperties.class)
public class DemoController {

    @Autowired
    private AliyunProperties aliyunProperties;

    @Autowired
    private MyProfileProperties myProfileProperties;
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

    @GetMapping("/aliyun")
    public AliyunProperties aliyun() {
        return aliyunProperties;
    }

    @GetMapping("/param")
    public String getParam() {
        throw new IllegalArgumentException();
        // return myProfileProperties.getName();
    }
}
