package com.haer.mybatisstudy;

import com.github.pagehelper.PageHelper;
import com.haer.mybatisstudy.domain.Student;
import com.haer.mybatisstudy.mapper.StudentMapper;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MybatisStudyApplicationTests {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
        ArrayList<Student> students = Lists.newArrayList();
        for (int i = 3; i < 300; i++) {
            Student student = new Student();
            student.setName("zhangsan" + i);
            students.add(student);
        }
        int i = studentMapper.insertBatch(students);
        System.out.println(i);
    }

    @Test
    void t2() {
        int pageSize = 10;
        int pageNum = 2;
        PageHelper.startPage(pageNum, pageSize, true);
        List<Student> students = studentMapper.findStudents();
        System.out.println(students);
    }

    @Test
    void t3() {
        //如果pageSize等于0，分批查询，每次查50条
        //如果pageSize大于0，小于等于50，正常查询
        //如果pageSize大于50，分批查询，每次查50条
        List<Student> allStudents = Lists.newArrayList();
        int pageSize = 60;
        int pageNum = 1;
        if (pageSize <= 0) {
            int count = studentMapper.countAll();
            int times = (count+49)/50;
            for (int i = 0; i < times; i++) {
                PageHelper.startPage(i, 50, false);
                List<Student> students = studentMapper.findStudents();
                allStudents.addAll(students);
            }
        } else if (pageSize > 0 && pageSize <= 50) {
            PageHelper.startPage(pageNum, pageSize, true);
            List<Student> students = studentMapper.findStudents();
            allStudents.addAll(students);
        }else {
            int times = (pageSize+49)/50;
            for (int i = 0; i < times; i++) {
                PageHelper.startPage(pageNum, 50, false);
                PageHelper.offsetPage()
                List<Student> students = studentMapper.findStudents();
                allStudents.addAll(students);
            }
        }
        System.out.println(allStudents);

    }

}
