package com.lukye.javaweblab.springexample.service;

import com.lukye.javaweblab.springexample.mapper.UserMapper;
import com.lukye.javaweblab.springexample.model.User;
import org.apache.ibatis.binding.MapperProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper)
    {
        this.mapper = mapper;
    }

    public void insert(User user)
    {
        mapper.insert(user);
    }
}