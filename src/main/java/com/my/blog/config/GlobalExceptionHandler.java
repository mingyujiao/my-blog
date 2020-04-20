package com.my.blog.config;

import com.my.blog.util.ResultBean;
import com.my.blog.util.ResultEnum;
import com.my.blog.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/10 22:17
 * 异常统一处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object logicExceptionHandler(HttpServletRequest request, Exception e, HttpServletResponse response) {
        //系统级异常，错误码固定为-1，提示语固定为系统繁忙，请稍后再试
        ResultBean result = ResultUtil.error(ResultEnum.UNKNOWN_ERROR.getCode(), ResultEnum.UNKNOWN_ERROR.getMsg());
        // 处理参数错误，统一拦截
        if (e instanceof MethodArgumentNotValidException) {
            String message = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().iterator().next().getDefaultMessage();
            result = ResultUtil.error(ResultEnum.PARAMETER_ERROR.getCode(), message);
        } else if (e instanceof ConstraintViolationException) {
            String message = ((ConstraintViolationException) e).getConstraintViolations().iterator().next().getMessage();
            result = ResultUtil.error(ResultEnum.PARAMETER_ERROR.getCode(), message);
        } else {
            //对系统级异常进行日志记录
            log.error("系统异常:{}", e.getMessage(), e);
        }
        return result;
    }

}
