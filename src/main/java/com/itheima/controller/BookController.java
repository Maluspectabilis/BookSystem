package com.itheima.controller;

import com.itheima.pojo.Book;
import com.itheima.pojo.HaveBooks;
import com.itheima.pojo.Student;
import com.itheima.service.BookService;
import com.itheima.service.HaveBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/Book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private HaveBooksService haveBooksService;

    @RequestMapping("/addBookInit")
    public String init1(HttpServletRequest request,Model model) {
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "book/addBook";
    }

    @RequestMapping("/deleteBookInit")
    public String init2(HttpServletRequest request,Model model) {

        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "book/deleteBook";
    }

    @RequestMapping("/selectAllBooks")
    public String selectAll(Model model, HttpServletRequest request){
        List<Book> books = bookService.showAll();
        for (Book book : books) {
            System.out.println(book);
        }
        model.addAttribute("books", books);
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "book/selectAllBooks";
    }

    @RequestMapping("/StudentSelectAllBooks")
    public String selectAll1(Model model,HttpServletRequest request){
        List<Book> books = bookService.showAll();
        for (Book book : books) {
            System.out.println(book);
        }
        model.addAttribute("books", books);
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "book/StudentSelectAllBooks";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book,HttpServletRequest request,Model model){

        bookService.addBook(book);
        model.addAttribute("book", book.getBookName());
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "success/addBookSuccess";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookName") String bookName,HttpServletRequest request,Model model){
        bookService.deleteBook(bookName);
        haveBooksService.deleteBook2(bookName);
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "success/deleteBookSuccess";
    }

    @RequestMapping("/borrowBook")
    public String borrowBook(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));

        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);

        book.setAuthor(author);
        book.setNumber(number);

        if(number!=0){///////////////还有书可以借

            book.setNumber(number-1);

            bookService.updateBook(book);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH：mm：ss");
            String formattedDateTime = now.format(formatter);

            System.out.println(formattedDateTime);

            HaveBooks haveBooks=new HaveBooks();
            haveBooks.setTime(formattedDateTime);
            haveBooks.setBookName(bookName);
            haveBooks.setBookPrice(bookPrice);
            haveBooks.setAuthor(author);
            haveBooks.setNumber(book.getNumber());//要-1

            String name=request.getParameter("name");
            model.addAttribute("name",name);
            String account=request.getParameter("account");
            model.addAttribute("account",account);

            haveBooks.setAccount(account);

            haveBooksService.addBook(haveBooks);

            return "success/borrowBookSuccess";
    }
        return "failed/cantBorrow";
    }


    @RequestMapping("/returnBook")
    public String returnBook(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));

        Book book = new Book();

        book.setBookName(bookName);
        book.setBookPrice(bookPrice);

        book.setAuthor(author);
        book.setNumber(number);

        book.setNumber(number+1);
        bookService.updateBook(book);

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

        haveBooksService.deleteBook(bookName);

        String name=request.getParameter("name");
        model.addAttribute("name",name);

        String account=request.getParameter("account");
        model.addAttribute("account",account);

        return "success/returnBookSuccess";
    }

    @RequestMapping("/borrowBook2")
    public String borrowBook2(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));
        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setAuthor(author);
        if(number!=0){
            book.setNumber(number-1);
            bookService.updateBook(book);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH：mm：ss");
            String formattedDateTime = now.format(formatter);
            HaveBooks haveBooks=new HaveBooks();
            haveBooks.setTime(formattedDateTime);
            haveBooks.setBookName(bookName);
            haveBooks.setBookPrice(bookPrice);
            haveBooks.setAuthor(author);
            haveBooks.setNumber(book.getNumber());
            String name=request.getParameter("name");
            model.addAttribute("name",name);
            String account=request.getParameter("account");
            model.addAttribute("account",account);
            haveBooks.setAccount(account);
            haveBooksService.addBook(haveBooks);
            return "success/student/borrowBookSuccess";
    }
        book.setNumber(number);
        return "success/student/cantBorrow";
    }

    @RequestMapping("/returnBook2")
    public String returnBook2(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));
        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);
        book.setAuthor(author);
        book.setNumber(number);
        book.setNumber(number+1);
        bookService.updateBook(book);
        haveBooksService.deleteBook(bookName);
        String name=request.getParameter("name");
        model.addAttribute("name",name);
        String account=request.getParameter("account");
        model.addAttribute("account",account);
        return "success/student/returnBookSuccess";
    }

    @RequestMapping("/borrowBook3")
    public String borrowBook3(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));

        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);

        book.setAuthor(author);

        if(number!=0){

            book.setNumber(number-1);
            bookService.updateBook(book);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH：mm：ss");
            String formattedDateTime = now.format(formatter);

            System.out.println(formattedDateTime);

            HaveBooks haveBooks=new HaveBooks();
            haveBooks.setTime(formattedDateTime);
            haveBooks.setBookName(bookName);
            haveBooks.setBookPrice(bookPrice);
            haveBooks.setAuthor(author);
            haveBooks.setNumber(book.getNumber());


            String name=request.getParameter("name");
            //        System.out.println(name);
            model.addAttribute("name",name);

            String account=request.getParameter("account");
            model.addAttribute("account",account);

            haveBooks.setAccount(account);

            haveBooksService.addBook(haveBooks);

            System.out.println(haveBooks);

            return "success/student/borrowBookSuccess2";
        }
        book.setNumber(number);
        return "success/student/cantBorrow2";
    }

    @RequestMapping("/borrowBook4")
    public String borrowBook4(HttpServletRequest request,Model model){
        String bookName = request.getParameter("bookName");
        int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
        String author = request.getParameter("author");
        int number = Integer.parseInt(request.getParameter("number"));

        Book book = new Book();
        book.setBookName(bookName);
        book.setBookPrice(bookPrice);

        book.setAuthor(author);

        if(number!=0){

            book.setNumber(number-1);
            bookService.updateBook(book);

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd--HH：mm：ss");
            String formattedDateTime = now.format(formatter);

            System.out.println(formattedDateTime);

            HaveBooks haveBooks=new HaveBooks();
            haveBooks.setTime(formattedDateTime);
            haveBooks.setBookName(bookName);
            haveBooks.setBookPrice(bookPrice);
            haveBooks.setAuthor(author);
            haveBooks.setNumber(book.getNumber());


            String name=request.getParameter("name");
            //        System.out.println(name);
            model.addAttribute("name",name);

            String account=request.getParameter("account");
            model.addAttribute("account",account);

            haveBooks.setAccount(account);

            haveBooksService.addBook(haveBooks);

            System.out.println(haveBooks);

            return "success/student/borrowBookSuccess3";
        }
        book.setNumber(number);
        return "success/student/cantBorrow3";
    }


}
