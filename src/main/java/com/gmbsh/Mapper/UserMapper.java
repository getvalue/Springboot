package com.gmbsh.Mapper;

import com.gmbsh.Entity.UserEntity;
import com.gmbsh.util.PageData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     */
    public List<UserEntity> findAll();

    /**
     * 查询某一个用户
     */
    public UserEntity findOne(String id);

    public void save(PageData pd);

    public PageData loginOne(PageData pd);
}
