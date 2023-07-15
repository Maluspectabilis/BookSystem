package com.itheima.controller;

import com.itheima.pojo.Book;
import com.itheima.pojo.HaveBooks;
import com.itheima.service.BookService;
import com.itheima.service.HaveBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/HaveBooks")
public class HaveBooksController {

    @Autowired
    private HaveBooksService haveBooksService;
    @Autowired
    private BookService bookService;

    @RequestMapping("/showAll")
    public String showAll(Model model,HttpServletRequest request){
        List<HaveBooks> haveBooks1 = haveBooksService.showAll();

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);

        List<HaveBooks> haveBooksList = new ArrayList<>();

        for(HaveBooks haveBooks:haveBooks1){

            if(haveBooks.getAccount().equals(account)){
                haveBooksList.add(haveBooks);
            }

        }

        model.addAttribute("haveBooks",haveBooksList);

        return "haveBooks/showAll";
    }

    @RequestMapping("/returnBook")
    public String returnBook(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));

        Book book = new Book();
        List<Book> books=bookService.showAll();
        for(Book book1:books){
            if(book1.getBookName().equals(bookName)){

                book.setBookName(bookName);
                book.setBookPrice(bookPrice);
                book.setAuthor(author);
                book.setNumber(number);

                book.setNumber(book1.getNumber()+1);
            }
        }
        bookService.updateBook(book);
        haveBooksService.deleteBook(bookName);

        HaveBooks haveBooks=new HaveBooks();
        haveBooks.setBookName(bookName);
        haveBooks.setBookPrice(bookPrice);
        haveBooks.setAuthor(author);

        String time = request.getParameter("time");
        String account1 = request.getParameter("account");
        haveBooks.setAccount(account1);
        haveBooks.setTime(time);

        haveBooks.setNumber(book.getNumber());//其余要+1
//        haveBooksService.updateBook(haveBooks);////////////////////////////////////////////////////////////

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "success/haveBooks/returnBookSuccess";
    }

    @RequestMapping("/showAll2")
    public String showAll2(Model model,HttpServletRequest request){
        List<HaveBooks> haveBooks1 = haveBooksService.showAll();

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);

        List<HaveBooks> haveBooksList = new ArrayList<>();

        for(HaveBooks haveBooks:haveBooks1){

            if(haveBooks.getAccount().equals(account)){
                haveBooksList.add(haveBooks);
            }

        }

        model.addAttribute("haveBooks",haveBooksList);

        return "haveBooks/showAll2";
    }

    @RequestMapping("/returnBook2")
    public String returnBook2(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));

        Book book = new Book();
        List<Book> books=bookService.showAll();
        for(Book book1:books){
            if(book1.getBookName().equals(bookName)){

                book.setBookName(bookName);
                book.setBookPrice(bookPrice);
                book.setAuthor(author);
                book.setNumber(number);

                book.setNumber(book1.getNumber()+1);
            }
        }
        bookService.updateBook(book);
        haveBooksService.deleteBook(bookName);

        HaveBooks haveBooks=new HaveBooks();
        haveBooks.setBookName(bookName);
        haveBooks.setBookPrice(bookPrice);
        haveBooks.setAuthor(author);
        haveBooks.setNumber(book.getNumber());//其余要+1

        String time = request.getParameter("time");
        String account1 = request.getParameter("account");
        haveBooks.setAccount(account1);
        haveBooks.setTime(time);

//        haveBooksService.updateBook(haveBooks);////////////////////////////////////////////////////////////

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "success/haveBooks/returnBookSuccess2";
    }
}
