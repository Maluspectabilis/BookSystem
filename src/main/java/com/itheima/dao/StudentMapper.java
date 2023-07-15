package com.itheima.dao;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    List<Student> showAll();

    Student showOne(String account);

    Integer addStudent(Student student);

    void deleteStudent(String account);

    void updateStudent(Student student);

    Student selectStudentByAccountAndPassword(@Param("account") String account,@Param("password") String password);

}