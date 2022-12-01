package com.example.demo.controller.execptionhandler;

import com.example.demo.controller.respbean.RespBean;
import com.example.demo.controller.respbean.RespBeanBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.text.ParseException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * IO异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    public RespBean handleIO(IOException e){
        RespBeanBuilder<String> respBeanBuilder = new RespBeanBuilder<>();
        return respBeanBuilder.addCode(0).addMsg("文件操作异常，请联系管理员").addData(e.getMessage()).bulid();
    }

    /**
     * 运行时异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public RespBean handler(RuntimeException e) {
        log.error("运行时异常：----------------{}", e);
//        RespBeanBuilder<String> respBeanBuilder = new RespBeanBuilder<>();
//        return respBeanBuilder.addCode(0).addMsg("操作异常，请联系管理员").addData(e.getMessage()).bulid();
        return RespBean.fail("操作异常，请联系管理员", e.getMessage());
    }

    /**
     * 日期解析异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = ParseException.class)
    public RespBean handlerParse(ParseException e) {
        log.error("运行时异常：----------------{}", e);
        return RespBean.fail("解析异常，请联系管理员", e.getMessage());
    }


}
