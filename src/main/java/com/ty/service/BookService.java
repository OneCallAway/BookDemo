package com.ty.service;

import com.ty.po.AppointExecution;
import com.ty.po.Appointment;
import com.ty.po.Book;
import com.ty.po.Student;

import java.util.List;

/**
 * @author pc
 * @create 2018-05-21 下午2:42
 * @desc bookService
 **/


public interface BookService {
    /**
     * 查询一本图书
     * @Param bookId
     */
    Book getById(int bookId);

    /**
     * 查询所有图书
     */
    List<Book> getList();

    /**
     * 登录时查询数据库是否有该学生记录
     */
    Student validateStu(int studentId,int password);

    /**
     * 按图书名称查询
     * 按条件搜寻
     */
    List<Book> getSomeList(String name);

    /**
     * 查询某学生预约的所有图书
     */
    List<Appointment> getAppointByStu(int studentId);

    /**
     * 预约图书
     */
    AppointExecution appoint(int bookId, int studentId);
}
