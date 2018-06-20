package com.gmbsh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gmbsh.Mapper.PermissionMapper;
import com.gmbsh.service.PermissionService;
import com.gmbsh.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shil
 * @date 2018/6/20 10:23
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<PageData> getUserPermission(String username) {

        return permissionMapper.getUserPermission(username);
    }
}
