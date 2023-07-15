package com.itheima.pojo;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;

public class HaveBooks {

    private String bookName;
    private String author;
    private String time;
    private Integer bookPrice;
    private Integer number;
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public HaveBooks() {
    }

    @Override
    public String toString() {
        return "HaveBooks{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", time='" + time + '\'' +
                ", bookPrice=" + bookPrice +
                ", number=" + number +
                ", account='" + account + '\'' +
                '}';
    }

    public HaveBooks(String bookName, String author, String time, Integer bookPrice, Integer number, String account) {
        this.bookName = bookName;
        this.author = author;
        this.time = time;
        this.bookPrice = bookPrice;

        this.number = number;
        this.account = account;
    }
}
