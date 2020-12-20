package com.example.demo.mapper;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class DistrictMapperTest extends DemoApplicationTests {

    @Autowired
    private DistrictMapper mapper;

    @Test
    void findAll() {
        List<District> all = mapper.findAll();
        for (District district : all) {
            System.out.println(district);
        }
    }

    @Test
    void findOneById() {
        District oneById = mapper.findOneById(1);
        System.out.println(oneById);
    }
}