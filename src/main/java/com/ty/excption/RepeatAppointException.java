package com.ty.excption;

/**
 * @author pc
 * @create 2018-05-21 下午3:16
 * @desc 重复预约异常
 **/

public class RepeatAppointException extends RuntimeException {
    public RepeatAppointException(String message){
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause){
        super(message, cause);
    }
}
