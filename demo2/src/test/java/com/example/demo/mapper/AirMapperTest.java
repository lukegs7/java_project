package com.example.demo.mapper;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Air;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


class AirMapperTest extends DemoApplicationTests {

    @Autowired
    private AirMapper airMapper;

    @Test
    void findAll() {
        List<Air> result = airMapper.findAll();
        for (Air air : result) {
            System.out.println(air);
        }

    }
}