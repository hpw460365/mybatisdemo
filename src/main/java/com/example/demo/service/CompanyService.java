package com.example.demo.service;

import com.example.demo.bean.Company;
import com.example.demo.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Service
@Validated
public class CompanyService {

    @Autowired
    private CompanyMapper mapper;

    public void insert(@Valid Company company){
        mapper.insert(company);
    }

    public void validateArg(@NotBlank(message = "arg is blank") String args){

    }

}
