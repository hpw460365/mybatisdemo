package com.example.demo.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Company {

    private Integer id;

    private String name;

    private Date createTime;

//    private Set<Employee> employees;
}
