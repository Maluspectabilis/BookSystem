package com.itheima.service.impl;

import com.itheima.dao.HaveBooksMapper;
import com.itheima.pojo.HaveBooks;
import com.itheima.service.HaveBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HaveBooksImpl implements HaveBooksService {

    @Autowired
    private HaveBooksMapper haveBooksMapper;

    @Override
    public void addBook(HaveBooks haveBooks) {
        haveBooksMapper.addBook(haveBooks);
    }

    @Override
    public void deleteBook(String bookName) {
        haveBooksMapper.deleteBook(bookName);
    }

    @Override
    public void deleteBook2(String bookName) {
        haveBooksMapper.deleteBook2(bookName);
    }

    @Override
    public List<HaveBooks> showAll() {
        return haveBooksMapper.showAll();
    }

    @Override
    public void updateBook(HaveBooks haveBooks) {
        haveBooksMapper.updateBook(haveBooks);
    }
}
