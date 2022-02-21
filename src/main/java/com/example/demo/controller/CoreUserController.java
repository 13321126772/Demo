package com.example.demo.controller;

import com.example.demo.Utils.JwtTokenUtil;
import com.example.demo.Utils.RSAKeyProperties;
import com.example.demo.pojo.CoreUser;
import com.example.demo.services.CoreUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/CoreUser")
public class CoreUserController {

    @Autowired
    private CoreUserService coreUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RSAKeyProperties rsaKeyProperties;

    //查询所有coreUser信息
    @RequestMapping("/findCoreUserAll")
    public List<CoreUser> findCoreUserAll(){
        List<CoreUser> resultLsit=coreUserService.findCoreUserAll();
        return resultLsit;
    };
    //使用JWT创建Token存入Cokie中,-----------公钥加密
    @RequestMapping("/createTokenPublicKey")
    public void CreateToken(HttpServletResponse response){
        System.out.println("token开始生成");
        String token = jwtTokenUtil.generateToken("胡子强", rsaKeyProperties.getPrivateKey());
        System.out.println(token);
        System.out.println("Token生成成功");
        //存入Cokie中
        System.out.println("创建Cookie添加Token");
        Cookie tokenCookie = new Cookie("token", token);
        response.addCookie(tokenCookie);
        System.out.println("cookie添加成功");
    }
}
