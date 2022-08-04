package com.example.demo;

import com.example.demo.bean.Company;
import com.example.demo.mapper.CompanyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	CompanyMapper companyMapper;
	@Test
	public void toTest1(){
		List<Company> userLogins = companyMapper.queryAll();
		userLogins.forEach(e-> System.out.println(e));
	}

	@Test
	public void toTest2(){
		Company company = new Company();
		company.setName("name1");
		company.setCreateTime(new Date());
		companyMapper.insert(company);
	}
}
