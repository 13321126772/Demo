package com.example.demo.mapper;

import com.example.demo.pojo.CmsBlog;

import java.util.List;
import java.util.Map;

public interface CmsBlogMapper {

     List<CmsBlog> findCmsBlogAll();

    CmsBlog findBlogById(String id);

    List<Map<String, Object>> findCmsBlogByID(String cmsid);
}
