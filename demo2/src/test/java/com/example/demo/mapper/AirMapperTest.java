package com.example.demo.mapper;

import com.example.demo.DemoApplicationTests;
import com.example.demo.entity.Air;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Test
    public void findByPage() {
        //1、执行分页
        PageHelper.startPage(1, 5);
        //2、执行查询
        List<Air> list = airMapper.findAll();
        //3、封装pageInfo对象
        PageInfo<Air> pageInfo = new PageInfo<>(list);
        //4、输出
        for (Air air : pageInfo.getList()) {
            System.out.println(air);
        }
    }
}