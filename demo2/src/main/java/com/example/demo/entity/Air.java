package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Air implements Serializable {
    private long id;
    private long districtId;
    private java.sql.Date monitorTime;
    private long pm10;
    private long pm25;
    private String monitoringStation;
    private java.sql.Date lastModifyTime;

}
