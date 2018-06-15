package com.gmbsh.service.impl;

import com.gmbsh.Entity.PermissionEntity;
import com.gmbsh.Mapper.RoleMapper;
import com.gmbsh.Mapper.UserMapper;
import com.gmbsh.service.RoleService;
import com.gmbsh.util.PageData;
import com.gmbsh.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<PermissionEntity> findPermissionListByRoleID(String roleid) {
        return roleMapper.findPermissionByRoleID(roleid);
    }

    @Override
    public void save(PageData pd) {
        roleMapper.save(pd);
    }
    //回滚测试
    @Transactional
    @Override
    public void addRoleUser(PageData pd) {
        roleMapper.save(pd);
        userMapper.save(pd);
    }


}
