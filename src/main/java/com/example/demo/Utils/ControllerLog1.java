package com.example.demo.Utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(1)
public class ControllerLog1 {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RSAKeyProperties rsaKeyProperties;

    //设置切入点
    @Pointcut("execution(public * com.example.demo.controller.*.*(..))")
    public void controllerLog1(){};

    @Before("controllerLog1()")
    public void before(){
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
//        System.out.println("检验用户请求");
//        //根据Cookie获取Token
//        Cookie[] cookies = request.getCookies();
//        String cookueValue = null;
//        if(cookies!=null) {
//            //遍历Cookie获取Token
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("token")){
//                    cookueValue= cookie.getValue();
//                }
//            }
//        }
//        if(cookueValue!=null){
//            //使用jwt解析
//            jwtTokenUtil.validateToken(cookueValue,"胡子强",rsaKeyProperties.getPublicKey());
//        }

    }
}
