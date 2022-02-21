package com.example.demo.servicesImpl;

public interface CmsBlogServices {

    default void findAll(){
        System.out.println("执行了");
    };


}
