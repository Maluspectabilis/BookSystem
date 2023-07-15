package com.itheima.controller;

import com.itheima.pojo.Admin;
import com.itheima.pojo.Student;
import com.itheima.service.AdminService;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/System")
public class LoginController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdminService adminService;

    @RequestMapping("/studentLoginInit")
    public String studentLoginInit(){
        return "student/studentLogin";
    }

    @RequestMapping("/studentRegisterInit")
    public String studentRegisterInit(){
        System.out.println("hhhhhh");
        return "student/studentRegister";
    }

    @RequestMapping("/adminLoginInit")
    public String adminLoginInit(){
        return "admin/adminLogin";
    }

    @RequestMapping("/adminRegisterInit")
    public String adminRegisterInit(){
        System.out.println("hhhhhh");
        return "admin/adminRegister";
    }

    @RequestMapping("/studentLogin")
    public String studentLogin(@RequestParam("account") String account, @RequestParam("password") String password, Model model, HttpSession httpSession){
        System.out.println("登录验证中...");

        /*这里要进行service业务操作：判断账号密码是否正确。根据service返回值来进行相应页面跳转。当账号验证失败跳转回登录页面，否则进入主页面*/
        int result = studentService.getStudent(account,password);
        System.out.println(account);
        System.out.println(result);
        if(result == 1){
            //登录验证通过，跳转到主页面，同时将账号密码放置于session中方便以后操作中提取
            httpSession.setAttribute("account",account);
            httpSession.setAttribute("password",password);
            model.addAttribute("verification", "true");

            Student student=studentService.selectStudentByAccountAndPassword(account, password);
            model.addAttribute("name",student.getStudentName());
            model.addAttribute("account",account);

            return "student/studentMain";
        }else{
            //用户不存在，登录失败：返回登录页面并提示相关信息
            model.addAttribute("verification", "false");//跳转到login并提示信息
            model.addAttribute("msg", "登录失败，请检查用户名/密码");
            return "student/studentLogin";
        }
    }

    @PostMapping("/studentRegister")
    public String studentRegister(Student student, Model model){
        System.out.println("到了"+student.getAccount()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        int result = studentService.addStudent(student);
        System.out.println(student.getSex());
        if(result == 1){
            model.addAttribute("verification", "true");
            model.addAttribute("msg", "注册成功,请登录");
            model.addAttribute("name",student.getStudentName());
            model.addAttribute("account",student.getAccount());
            return "student/studentLogin";
        }else{
            model.addAttribute("verification", "false");
            model.addAttribute("msg", "注册失败，请填写信息完整,或者账号重复");
            return "student/studentRegister";
        }
    }

    @RequestMapping("/adminLogin")
    public String adminLogin(@RequestParam("account") String account, @RequestParam("password") String password, Model model, HttpSession httpSession){
        System.out.println("登录验证中...");
        /*这里要进行service业务操作：判断账号密码是否正确。根据service返回值来进行相应页面跳转。当账号验证失败跳转回登录页面，否则进入主页面*/
        int result = adminService.getAdmin(account,password);
        System.out.println(account);
        System.out.println(result);


        if(result == 1){
            //登录验证通过，跳转到主页面，同时将账号密码放置于session中方便以后操作中提取
            httpSession.setAttribute("account",account);
            httpSession.setAttribute("password",password);
            model.addAttribute("verification", "true");
            Admin admin=adminService.selectAdminByAccountAndPassword(account, password);
            model.addAttribute("name",admin.getAdminName());

            model.addAttribute("account",account);

            return "admin/adminMain";
        }else{
            //用户不存在，登录失败：返回登录页面并提示相关信息
            model.addAttribute("verification", "false");//跳转到login并提示信息
            model.addAttribute("msg", "登录失败，请检查用户名/密码");
            return "admin/adminLogin";
        }
    }

    @PostMapping("/adminRegister")
    public String adminRegister(Admin admin, Model model){
        System.out.println("到了");
        int result = adminService.addAdmin(admin);

        System.out.println(admin.getSex());
        if(result == 1){
            model.addAttribute("verification", "true");
            model.addAttribute("msg", "注册成功,请登录");
            model.addAttribute("name",admin.getAdminName());
            model.addAttribute("account",admin.getAccount());
            return "admin/adminLogin";
        }else{
            model.addAttribute("verification", "false");
            model.addAttribute("msg", "注册失败，请填写信息完整,或者账号重复");
            return "admin/adminRegister";
        }
    }

}