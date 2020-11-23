package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class District implements Serializable {
    private long id;
    private String name;
}
