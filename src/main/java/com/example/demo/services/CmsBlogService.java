package com.example.demo.services;

import com.example.demo.Utils.RedisUtil;
import com.example.demo.mapper.CmsBlogMapper;
import com.example.demo.pojo.CmsBlog;
import com.example.demo.servicesImpl.CmsBlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CmsBlogService implements CmsBlogServices {

    @Autowired
    private CmsBlogMapper cmsBlogMapper;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private RedisUtil redisUtil;

    public List<CmsBlog> findCmsBlogAll() {
        //从Redis里获取用户信息
        Map<Object, Object> resultMap = redisUtil.hmget("key");
        //缓存中存在数据
        if(resultMap.size()>0){
            List<CmsBlog> resultList = new ArrayList<>();
            for (Object o : resultMap.values()) {
                resultList.add((CmsBlog) o);
            }
            System.out.println("缓存");
            return resultList;
        }else{
            //不存在数据 获取数据 存入数据库
            List<CmsBlog> cmsBlogAll = cmsBlogMapper.findCmsBlogAll();
            for (int i=0;i<cmsBlogAll.size();i++){
                redisUtil.hset("key",cmsBlogAll.get(i).getId().toString(),cmsBlogAll.get(i));
            }
            System.out.println("数据库");
            return cmsBlogAll;
        }

    }

    public CmsBlog findBlogByid(String id) {
        return cmsBlogMapper.findBlogById(id);
    }

    public void createHtml(String cmsid, String path, String houzhui) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "tellsea");
        map.put("age", 20);
        map.put("email", "3210054449@qq.com");


        //创建上下文，
        Context context = new Context();
        //上下文里添加数据
        context.setVariables(map);
        //输出流
        File file=new File(path,"65535"+houzhui);
        //校验是否存在文件
        if(file.exists()){
            file.delete();
        }
        //创建PrintWriter类输出文件到指定文件
        PrintWriter printWriter=new PrintWriter(file,"UTF-8");
        templateEngine.process("index", context,printWriter);

        printWriter.close();
        printWriter.flush();
    }

}
