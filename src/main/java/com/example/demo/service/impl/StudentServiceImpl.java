package com.example.demo.service.impl;

import com.example.demo.bean.TestPerson;
import com.example.demo.bean.TestPersonExample;
import com.example.demo.mapper.TestPersonMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TestPersonMapper mapper;

    @Override
    public int importData(@Valid  List<TestPerson> students) {
        //参数校验

        //2.入库
        int successNum = students.size();
        for(TestPerson person: students){
            mapper.insert(person);
        }
        return successNum;
    }

    @Override
    public List<TestPerson> getList() throws ParseException {
        //拼接条件
        TestPersonExample example = new TestPersonExample();
        example.createCriteria().andRksjBetween(DateFormat.getDateInstance().parse("2022/12/1"), DateFormat.getDateInstance().parse("2022/12/2"));
        return mapper.selectByExample(example);
    }
}
