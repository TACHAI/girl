package com.laohu.exception;

/**
 * Created by asus30 on 2017/8/12.
 *
 * 只抛Runtime异常 才会回滚
 */
public class GirlException extends RuntimeException {
    private Integer code;
    public GirlException(Integer code,String message){
        super(message);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
