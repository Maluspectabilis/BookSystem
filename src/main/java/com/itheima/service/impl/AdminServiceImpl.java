package com.itheima.service.impl;

import com.itheima.dao.AdminMapper;
import com.itheima.dao.StudentMapper;
import com.itheima.pojo.Admin;
import com.itheima.pojo.Student;
import com.itheima.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public Integer addAdmin(Admin admin) {
        int result = 0;
        try{
                List<Admin> admins=adminMapper.selectAll();
                List<Student> students=studentMapper.showAll();
            if(admin.getAdminName()==null||admin.getPassword()==null||admin.getAge()==null||admin.getPhoneNumber()==null||admin.getAccount()==null||admin.getSex()==null){
                System.out.println("注册失败，请填写信息完整");
                result=0;
            }else{
                result = 1;
                for(Admin admin1:admins){
                    if(admin.getAccount().equals(admin1.getAccount())){
                        result = 0;
                    }
                }
                for(Student student1:students){
                    if(admin.getAccount().equals(student1.getAccount())){
                        result = 0;
                    }
                }
                if(result==1)
                    adminMapper.addAdmin(admin);
                else System.out.println("注册失败，账号重复");
            }
        }catch (Exception e){
            e.printStackTrace();//查询语句错误
        }
        return result;
    }

    @Override
    public void deleteAdmin(String account) {
        adminMapper.deleteAdmin(account);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public Integer getAdmin(String account, String password) {
        int result = 0;//默认验证失败
        try{
            Admin admin = adminMapper.selectAdminByAccountAndPassword(account,password);
            System.out.println(admin.getPassword());
            System.out.println(result);
            if (admin == null) {
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
    public Admin selectAdminByAccountAndPassword(String account, String password) {
        return adminMapper.selectAdminByAccountAndPassword(account, password);
    }

}
