package com.ty.po;

/**
 * @author pc
 * @create 2018-05-21 下午12:06
 * @desc book实体
 **/

public class Book {
    private int bookId;
    private String name;
    private int number;
    private String introd;


    public Book(){
    }

    public Book(int bookId,String name,int number,String introd){
        this.bookId = bookId;
        this.name = name;
        this.number = number;
        this.introd = introd;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String nama) {
        this.name = nama;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", introd='" + introd + '\'' +
                '}';
    }
}
