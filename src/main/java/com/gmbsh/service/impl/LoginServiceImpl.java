package com.gmbsh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gmbsh.Mapper.UserMapper;
import com.gmbsh.service.LoginService;
import com.gmbsh.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shil
 * @date 2018/6/20 0:37
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Override
    public PageData getUser(PageData pd) {
        return  userMapper.loginOne(pd);
    }
}
