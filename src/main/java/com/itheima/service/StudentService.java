package com.itheima.service;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    public List<Student> showAll();

    public Student showOne(String account);

    public Integer addStudent(Student student);

    public void deleteStudent(String account);

    public void updateStudent(Student student);

    public Integer getStudent(String account,String password);

    Student selectStudentByAccountAndPassword(@Param("account") String account, @Param("password") String password);

}
