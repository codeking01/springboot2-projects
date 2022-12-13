package com.codeking.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author : codeking
 * @create : 2022/12/13 23:34
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    // 自定义处理异常
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithException(Exception e) {
        log.error("异常是{}",e);
        return "login";
    }
}
