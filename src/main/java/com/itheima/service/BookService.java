package com.itheima.service;

import com.itheima.pojo.Book;

import java.util.List;

public interface BookService {
    public List<Book> showAll();

    public Book showOne(String bookName);

    public void addBook(Book book);

    public void deleteBook(String bookName);

    public void updateBook(Book book);
}
