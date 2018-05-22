package com.ty.excption;

/**
 * @author pc
 * @create 2018-05-21 下午3:14
 * @desc 库存不足异常
 **/

public class NoNumberException extends RuntimeException {
    public NoNumberException(String message){
        super(message);
    }

    public NoNumberException(String message,Throwable cause){
        super(message, cause);
    }
}
