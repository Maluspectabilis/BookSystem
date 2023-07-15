package com.itheima.service.impl;

import com.itheima.dao.AdminMapper;
import com.itheima.dao.StudentMapper;
import com.itheima.pojo.Admin;
import com.itheima.pojo.Student;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Student> showAll() {
        return  studentMapper.showAll();
    }

    @Override
    public Student showOne(String account) {
        return studentMapper.showOne(account);
    }

    @Override
    public Integer addStudent(Student student) {
        int result = 0;
        try{
            if(student.getStudentName() == null||student.getStudentNumber() == null || student.getAccount()==null || student.getAge()==null ||student.getMajor()==null ||student.getSex()==null||student.getPassword()==null
            ){
                System.out.println("注册失败，请填写信息完整");
                result=0;
            }else{
                result = 1;
                List<Admin> admins=adminMapper.selectAll();
                List<Student> students=studentMapper.showAll();
                for(Student student1:students){
                    if(student.getAccount().equals(student1.getAccount())){
                        result=0;
                    }
                }
                for(Admin admin1:admins){
                    if(student.getAccount().equals(admin1.getAccount())){
                        result=0;
                    }
                }
                if(result==1)
                    studentMapper.addStudent(student);
                else
                    System.out.println("注册失败，账号重复");
            }
        }catch (Exception e){
            e.printStackTrace();//查询语句错误
        }
        return result;
    }

    @Override
    public void deleteStudent(String account) {
        studentMapper.deleteStudent(account);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public Integer getStudent(String account, String password) {
        int result = 0;//默认验证失败
        try{
            Student student = studentMapper.selectStudentByAccountAndPassword(account,password);
            System.out.println(student.getPassword());//
            System.out.println(result);
            if (student == null) {
                System.out.println("验证失败");
                result = 0;
            } else {
                System.out.println("验证成功");
                result = 1;
            }
        }catch (Exception e){
            e.printStackTrace();//查询语句错误
        }
        return result;
    }

    @Override
    public Student selectStudentByAccountAndPassword(String account, String password) {
        return studentMapper.selectStudentByAccountAndPassword(account,password);
    }
}
