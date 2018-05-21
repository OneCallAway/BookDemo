package com.ty.po;

/**
 * @author pc
 * @create 2018-05-21 下午12:06
 * @desc book实体
 **/

public class Book {
    private int BookId;
    private String nama;
    private int number;

    public Book(){

    }

    public Book(int bookId,String name,int number){
        this.BookId = bookId;
        this.nama = name;
        this.number = number;
    }

    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BookId=" + BookId +
                ", nama='" + nama + '\'' +
                ", number=" + number +
                '}';
    }
}
