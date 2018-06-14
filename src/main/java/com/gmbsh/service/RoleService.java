package com.gmbsh.service;

import com.gmbsh.Entity.PermissionEntity;

import java.util.List;

public interface RoleService {
    //获取角色所有权限
    public List<PermissionEntity> findPermissionListByRoleID(String roleid);
}
