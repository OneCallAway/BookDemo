package com.ty.mapper;

import com.ty.po.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pc
 * @create 2018-05-21 下午12:24
 * @desc appointmentDao
 **/

public interface AppointmentMapper {
    //根据学生id和图书id预约图书,并插入
    int insertAppointment (@Param("bookId")int bookId,@Param("studentId")int studentId);

    //通过学生id查询已预约图书
    List<Appointment> queryAndReturn(int studentId);
}

