package com.example.demo;

import com.example.demo.bean.TestPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@SpringBootTest
@Validated
class DemoApplicationTests {


	@Autowired
	TestPerson studentMapper;

	//	@Test
	public void toTest1() {
//		List<TestPerson> userLogins = studentMapper();
//		userLogins.forEach(e -> System.out.println(e));
	}
}