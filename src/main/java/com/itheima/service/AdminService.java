package com.itheima.service;

import com.itheima.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminService {

    public List<Admin> selectAll();

    public Integer addAdmin(Admin admin);

    void deleteAdmin(String account);

    void updateAdmin(Admin admin);

    public Integer getAdmin(String account,String password);

    Admin selectAdminByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}