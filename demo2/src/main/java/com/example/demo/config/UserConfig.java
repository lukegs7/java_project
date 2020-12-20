package com.example.demo.config;

import com.example.demo.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration  //代表当前类是一个配置类
public class UserConfig {

    @Bean(name="user")   // 构建一个实例，并放在spring容器中, name默认是方法名，也可以手动指定
    public User user() {
        User user = new User();
        user.setId(1);
        user.setName("zhangsan");
        return user;
    }

    @PostConstruct
    public void preConstruct() {
        System.out.println("It is pre construct");
    }
    @PreDestroy
    public void preDestroy() {
        System.out.println("it is going to be destroyed");
    }
}

/****
 <beans>  //默认方法名user就是id user，除非@Bean指定了name
    <bean id="user" class="com.example.demo.entity.User">

    <bean />
 <beans />
 */
