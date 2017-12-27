package com.gmbsh.service.impl;

import com.gmbsh.Entity.UserEntity;
import com.gmbsh.Mapper.UserMapper;
import com.gmbsh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    //注入代理对象
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> userlist = userMapper.findAll();
        return userlist;
    }

    @Override
    public UserEntity findOne(String id) {
        UserEntity user = userMapper.findOne(id);
        return user;
    }
}
