package com.itheima.controller;

import com.itheima.dao.BookMapper;
import com.itheima.pojo.Book;
import com.itheima.pojo.Student;
import com.itheima.service.BookService;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/studentMainInit")
    public String studentMainInit(HttpServletRequest request,Model model){

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);

        return "student/studentMain";
    }

    @RequestMapping("/addStudentInit")
    public String addStudentInit(HttpServletRequest request,Model model){

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "student/addStudent";
    }

    @RequestMapping("/addStudent")
    public String addStudent(Student student,HttpServletRequest request,Model model){
        int result = studentService.addStudent(student);
        String name=request.getParameter("name");
        model.addAttribute("name",name);
//        System.out.println(student.getAccount());


        String account=request.getParameter("account");
        model.addAttribute("account",account);

        if(result == 1){
            model.addAttribute("verification", "true");
            model.addAttribute("msg", "新增学生信息成功!");

            return "success/addStudentSuccess";
        }else{
            model.addAttribute("verification", "false");
            model.addAttribute("msg", "新增学生信息失败,账号重复!");
            return "success/addStudentSuccess";
        }
//        return "success/addStudentSuccess";
    }

    @RequestMapping("/selectAllStudents")
    public String selectAll(Model model,HttpServletRequest request){
        List<Student> students = studentService.showAll();
        for (Student student : students) {
            System.out.println(student);
        }
        model.addAttribute("students", students);
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "student/selectAllStudents";
    }

    @RequestMapping("/StudentShowOneInit")
    public String showOneInit1(HttpServletRequest request, Model model){
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "student/selectOne";
    }

    @RequestMapping("/studentShowOne")
    public String showOne1(String bookName,HttpServletRequest request,Model model){

        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);

        Book book=bookService.showOne(bookName);
        model.addAttribute("book",book);

        return "student/selectOne";
    }


}