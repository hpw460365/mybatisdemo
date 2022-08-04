package com.example.demo.mapper;

import com.example.demo.bean.Company;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CompanyMapper {

    public List<Company> queryAll();

    public void insert(Company company);
}
