package com.ty.mapper;

import com.ty.po.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @author pc
 * @create 2018-05-21 下午12:42
 * @desc StudentDao
 **/

public class StudentMapper {
    /**
     * 向数据库验证输入的密码是否正确
     */

    Student queryStudent(@Param("studentId")int studentId,@Param("password")int password);
}
