package com.itheima.service.impl;

import com.itheima.dao.BookMapper;
import com.itheima.pojo.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> showAll() {
        return bookMapper.showAll();
    }

    @Override
    public Book showOne(String bookName) {
        return bookMapper.showOne(bookName);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void deleteBook(String bookName) {
        bookMapper.deleteBook(bookName);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }
}
