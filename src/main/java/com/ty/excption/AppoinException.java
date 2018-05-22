package com.ty.excption;

import com.ty.po.AppointExecution;

/**
 * @author pc
 * @create 2018-05-21 下午3:12
 * @desc 预约义务异常
 **/

public class AppoinException extends RuntimeException {
    public AppoinException(String message){
        super(message);
    }

    public AppoinException(String message, Throwable cause){
        super(message, cause);
    }
}
