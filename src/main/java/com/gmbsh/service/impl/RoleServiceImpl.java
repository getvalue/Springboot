package com.gmbsh.service.impl;

import com.gmbsh.Entity.PermissionEntity;
import com.gmbsh.Mapper.RoleMapper;
import com.gmbsh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<PermissionEntity> findPermissionListByRoleID(String roleid) {
        return roleMapper.findPermissionByRoleID(roleid);
    }

}
