package com.itheima.pojo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Admin {

    private String adminName;
    private String password;
    private Integer age;
    private String phoneNumber;
    private String account;
    private String sex;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Admin(String adminName, String password, Integer age, String phoneNumber, String account, String sex) {
        this.adminName = adminName;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.sex = sex;
    }

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", account='" + account + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
