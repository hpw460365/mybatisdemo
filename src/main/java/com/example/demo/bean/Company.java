package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
public class Company {

    private Integer id;

    private String name;

    private Date createTime;

    private Set<Employee> employees;
}
