package com.lukye.javaweblab.springexample.service;

import com.lukye.javaweblab.springexample.mapper.UserMapper;
import com.lukye.javaweblab.springexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LongSummaryStatistics;
import java.util.StringJoiner;

@Service
public class UserService {
    private UserMapper mapper;

    public UserService()
    {
    }

    @Autowired
    public UserService(UserMapper mapper)
    {
        this.mapper = mapper;
    }

    public void insert(User user)
    {
        mapper.insert(user);
    }

    public void delete(String name)
    {
        mapper.deleteByPrimaryKey(name);
    }

    public User select(String name)
    {
        return mapper.selectByPrimaryKey(name);
    }
}
