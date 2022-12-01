package com.example.demo.mapper;

import com.example.demo.bean.TestPerson;
import com.example.demo.bean.TestPersonExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TestPersonMapper {
    long countByExample(TestPersonExample example);

    int deleteByExample(TestPersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TestPerson record);

    int insertSelective(TestPerson record);

    List<TestPerson> selectByExample(TestPersonExample example);

    TestPerson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TestPerson record, @Param("example") TestPersonExample example);

    int updateByExample(@Param("record") TestPerson record, @Param("example") TestPersonExample example);

    int updateByPrimaryKeySelective(TestPerson record);

    int updateByPrimaryKey(TestPerson record);
}