package me.lukegs7.springsecurity.securitydemo.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/hello")
    public String add() {
        return "hello security";
    }

    @GetMapping("/index")
    public String hello() {
        return "hello security";
    }

    // 只有具备normal和admin角色才可以访问当前方法
    @GetMapping("/update")
    // @Secured({"ROLE_normal","ROLE_admin"})
    // @PreAuthorize("hasAnyAuthority('admins')")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String update() {
        System.out.println("update.....");
        return "hello update";
    }
}
