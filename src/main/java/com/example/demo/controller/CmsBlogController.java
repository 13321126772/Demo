package com.example.demo.controller;

import com.example.demo.config.ThymeleafConfig;
import com.example.demo.pojo.CmsBlog;
import com.example.demo.services.CmsBlogService;
import com.example.demo.servicesImpl.CmsBlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/CmsBlog")
public class CmsBlogController {

    @Autowired
    private CmsBlogService cmsBlogService;
    @Autowired
    private ThymeleafConfig thymeleafConfig;
    @Autowired
    private CmsBlogServices cmsBlogServices;



    @RequestMapping("/findCmsBlogAll")
    public List<CmsBlog> findCmsBlogAll(){
        new CmsBlogServices(){
            public void blog(){

            }
        };
        return cmsBlogService.findCmsBlogAll();
    }

    @RequestMapping("/findBlogById")
    public CmsBlog findBlogById(@RequestParam("id") String id){
        return cmsBlogService.findBlogByid(id);
    }
    @RequestMapping("/createHTML")
    public void createHTML(String Cmsid){
        try {
            cmsBlogService.createHtml(Cmsid,thymeleafConfig.getPath(),thymeleafConfig.getHouzhui());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
