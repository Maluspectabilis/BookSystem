package com.itheima.controller;

import com.itheima.dao.BookMapper;
import com.itheima.pojo.Admin;
import com.itheima.pojo.Book;
import com.itheima.pojo.Student;
import com.itheima.service.AdminService;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/adminMainInit")
    public String init1(HttpServletRequest request, Model model){
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "admin/adminMain";
    }

    @RequestMapping("/AdminShowOneInit")
    public String showOneInit1(HttpServletRequest request, Model model){
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "admin/selectOne";
    }

    @RequestMapping("/AdminShowOne")
    public String showOne1(String account1,HttpServletRequest request,Model model){
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        Student student=studentService.showOne(account1);
        model.addAttribute("student",student);
        return "admin/selectOne";
    }

    @RequestMapping("/AdminShowOne2")
    public String showOne2(String bookName,Model model,HttpServletRequest request){
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        Book  book=bookMapper.showOne(bookName);
        model.addAttribute("book",book);
        return "admin/selectOne";
    }
}
