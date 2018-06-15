package com.gmbsh.service;

import com.gmbsh.Entity.UserEntity;
import com.gmbsh.util.PageData;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户
     */
    public List<UserEntity> findAll();
    /**
     * 查询某一个用户
     */
    public UserEntity findOne(String id);

    public void save(PageData pd);
}
