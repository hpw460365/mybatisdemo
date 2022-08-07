package com.example.demo.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Company {

//    @NotBlank(message = "id不能为空")
    private Integer id;

    @NotBlank(message = "name不能为空")
    @Length(max = 1)
    private String name;

    private Date createTime;

    private Integer version;

//    private Set<Employee> employees;
}
