package com.itheima.pojo;

public class Student {

    private String studentName;
    private String studentNumber;
    private String password;
    private Integer age;
    private String sex;
    private String major;
    private String account;

    public Student(String studentName, String studentNumber, String password, Integer age, String sex, String major, String account) {
        this.studentName = studentName;
        this.studentNumber = studentNumber;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.major = major;
        this.account = account;
    }

    public Student() {
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
