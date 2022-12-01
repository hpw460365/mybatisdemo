package com.example.demo.controller.respbean;

public class RespBeanBuilder<T> {
    private RespBean<T> respBean = new RespBean();

    public RespBeanBuilder addCode(int code){
        respBean.setCode(code);
        return this;
    }

    public RespBeanBuilder addMsg(String msg){
        respBean.setMsg(msg);
        return this;
    }

    public RespBeanBuilder addData(T data){
        respBean.setData(data);
        return this;
    }

    public RespBean<T> bulid(){
        return this.respBean;
    }
}
