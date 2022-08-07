package com.example.demo;

import com.example.demo.bean.Company;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Validated
class DemoApplicationTests {


	@Autowired
	CompanyMapper companyMapper;
//	@Test
	public void toTest1(){
		List<Company> userLogins = companyMapper.queryAll();
		userLogins.forEach(e-> System.out.println(e));
	}


	@Autowired
	private CompanyService companyService;

	@Test
	public void toTestInsert(){
		Company company = new Company();
//		company.setName("name2");
		company.setCreateTime(new Date());
		companyMapper.insert(company);
//		companyService.insert(company);
	}


//	@Test
	public void toTestValidationArgs(){
//		companyService.validateArg("");
		validateArgs("");
	}

	public void validateArgs(@NotBlank(message = "arg is blank") String arg){

	}



}
