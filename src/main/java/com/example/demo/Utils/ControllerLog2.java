package com.example.demo.Utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ControllerLog2 {

    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void controllerLog2(){};

    @Before("controllerLog2()")
    public void Before(){
        System.out.println("我是1");
    }
}
