package com.laohu.aspet;

import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by asus30 on 2017/8/12.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    private JoinPoint joinPoint;
    @Pointcut("execution(public * com.laohu.controller.GirlController.*(..))")
    public void log(){

    }
    @Before("log()")
    public void dobefore(){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("if={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("1111111111111");
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("22222222222222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturn(Object object){
        logger.info("response={}",object.toString());
    }
}
