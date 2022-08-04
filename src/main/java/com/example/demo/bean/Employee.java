package com.example.demo.bean;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
public class Employee {

    private Integer id;

    private String name;

    private BigDecimal money;

    private Integer age;

    private Company company;
}
