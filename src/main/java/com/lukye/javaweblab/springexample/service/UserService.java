package com.lukye.javaweblab.springexample.service;

import com.lukye.javaweblab.springexample.mapper.UserMapper;
import com.lukye.javaweblab.springexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

    public void delete(String name)
    {
        mapper.deleteByPrimaryKey(name);
    }

    public User select(String name)
    {
        return mapper.selectByPrimaryKey(name);
    }
}
