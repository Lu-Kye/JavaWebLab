package com.lukye.javaweblab.springexample.service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<TMapper, TModel> {
    @Autowired
    protected TMapper mapper;

    public TModel get(String id) {
        return null;
    }
}
