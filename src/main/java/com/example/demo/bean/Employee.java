package com.example.demo.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Employee {

    private Integer id;

    private String name;

    private BigDecimal money;

    private Integer age;

    private Company company;
}
