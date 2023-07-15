package com.itheima.pojo;

public class Book {

    private String bookName;

    private Integer bookPrice;
    private String author;
    private Integer number;

    public Book(String bookName,  Integer bookPrice, String author, Integer number) {
        this.bookName = bookName;

        this.bookPrice = bookPrice;
        this.author = author;
        this.number = number;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Integer bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", author='" + author + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
