package com.example.demo.controller.respbean;

import lombok.Data;

import java.io.Serializable;

@Data
public class RespBean<T> implements Serializable {

    //1成功， 0失败
    private int code;

    private String msg;

    private T data;

    public static <T>  RespBean fail(String msg, T data){
        RespBean bean = new RespBean();
        bean.setCode(0);
        bean.setData(data);
        bean.setMsg(msg);
        return bean;
    }

    public static <T>  RespBean succ(String msg, T data){
        RespBean bean = new RespBean();
        bean.setCode(1);
        bean.setData(data);
        bean.setMsg(msg);
        return bean;
    }


}
