package com.example.demo.service;

import com.example.demo.bean.TestPerson;

import java.text.ParseException;
import java.util.List;

public interface StudentService {

    //导库
    int importData(List<TestPerson> students);


    List<TestPerson> getList() throws ParseException;
}
