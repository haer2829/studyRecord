package com.haer.mybatisstudy.mapper;

import com.haer.mybatisstudy.domain.Student;

import java.util.List;

/**
* @author 28014
* @description 针对表【student】的数据库操作Mapper
* @createDate 2024-01-04 22:11:59
* @Entity com.haer.mybatisstudy.domain.Student
*/
public interface StudentMapper {

    int insertBatch(List<Student> list);

    List<Student> findStudents();

    int countAll();
}




