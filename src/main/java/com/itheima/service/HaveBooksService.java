package com.itheima.service;

import com.itheima.pojo.HaveBooks;

import java.util.List;

public interface HaveBooksService {
    public void addBook(HaveBooks haveBooks);

    public void deleteBook(String bookName);

    public void deleteBook2(String bookName);

    public List<HaveBooks> showAll();

    public void updateBook(HaveBooks haveBooks);
}
