package com.itheima.dao;

import com.itheima.pojo.Book;
import com.itheima.pojo.Student;

import java.util.List;

public interface BookMapper {

    public List<Book> showAll();

    public Book showOne(String bookName);

    public void addBook(Book book);

    public void deleteBook(String bookName);

    public void updateBook(Book book);
}
