package com.example.demo.services;

import com.example.demo.mapper.CoreUserMapper;
import com.example.demo.pojo.CoreUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoreUserService {

    @Autowired
    private CoreUserMapper coreUserMapper;

    public List<CoreUser> findCoreUserAll() {
        return coreUserMapper.findCoreUserAll();
    }
}
