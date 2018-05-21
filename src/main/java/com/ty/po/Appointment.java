package com.ty.po;

import java.util.Date;

/**
 * @author pc
 * @create 2018-05-21 下午12:08
 * @desc 预约实体
 **/

public class Appointment {
    private int bookId;
    private Date appointTime;

    private Book book;

    public Appointment(){

    }

    public Appointment(int bookId,Date appointTime){
        this.bookId = bookId;
        this.appointTime = appointTime;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", appointTime=" + appointTime +
                '}';
    }
}
