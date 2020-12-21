package com.example.demo.config;

import com.example.demo.filter.MyFilter;
import com.example.demo.filter.MyFilter2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyFilterConfig {
    @Autowired
    MyFilter myFilter;
    @Autowired
    MyFilter2 myFilter2;

    @Bean
    public FilterRegistrationBean<MyFilter> thirdFilter() {
        FilterRegistrationBean<MyFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter2> secondFilter() {
        FilterRegistrationBean<MyFilter2> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(myFilter2);
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.setUrlPatterns(new ArrayList<>(Arrays.asList("/api/*")));
        return filterRegistrationBean;
    }
}
