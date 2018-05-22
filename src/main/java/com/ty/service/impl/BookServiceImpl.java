package com.ty.service.impl;

import com.ty.excption.AppoinException;
import com.ty.excption.NoNumberException;
import com.ty.excption.RepeatAppointException;
import com.ty.mapper.AppointmentMapper;
import com.ty.mapper.BookMapper;
import com.ty.mapper.StudentMapper;
import com.ty.po.*;
import com.ty.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pc
 * @create 2018-05-21 下午3:17
 * @desc bookService实现类
 **/

@Service
public class BookServiceImpl implements BookService {

    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private StudentMapper studentMapper;



    @Override
    public Book getById(int bookId) {
        return bookMapper.queryById(bookId);
    }

    @Override
    public List<Book> getList() {
        return bookMapper.queryAll(0,1000);
    }

    @Override
    public Student validateStu(int studentId, int password) {
        return studentMapper.queryStudent(studentId,password);
    }

    @Override
    public List<Book> getSomeList(String name) {
        return bookMapper.querySome(name);
    }

    @Override
    public List<Appointment> getAppointByStu(int studentId) {
        return appointmentMapper.queryAndReturn(studentId);
    }

    @Override
    public AppointExecution appoint(int bookId, int studentId) {
        try {
            int update = bookMapper.reduceNumber(bookId); //减库存
            if(update <= 0){//无库存
                throw new NoNumberException("no number");
            }
            else {
                //执行预约操作
                int insert = appointmentMapper.insertAppointment(bookId,studentId);
                if(insert <= 0){//重复预约
                    throw new RepeatAppointException("repeat appoin");
                }
                else{
                    return new AppointExecution(bookId,AppointStateEnum.SUCCESS);
                }
            }
        } catch (NoNumberException e1) {
            throw e1;
        } catch (RepeatAppointException e2){
            throw e2;
        } catch (Exception e){
            logger.error(e.getMessage(), e);
            //所有编译期异常转为运行期异常
            throw new AppoinException("appoin inner error:" + e.getMessage());
        }

    }
}
