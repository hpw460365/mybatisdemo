package com.example.demo.mapper;

import com.example.demo.bean.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Mapper
@Repository
@Validated
public interface CompanyMapper{

    public List<Company> queryAll();

    public void insert(@Valid Company company);
}
