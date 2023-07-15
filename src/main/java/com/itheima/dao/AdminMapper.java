package com.itheima.dao;

import com.itheima.pojo.Admin;
import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {

    public List<Admin> selectAll();

    public Integer addAdmin(Admin admin);

    void deleteAdmin(String account);

    void updateAdmin(Admin admin);

    Admin selectAdminByAccountAndPassword(@Param("account") String account, @Param("password") String password);
}
