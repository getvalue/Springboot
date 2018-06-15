package com.gmbsh.service;

import com.gmbsh.Entity.PermissionEntity;
import com.gmbsh.util.PageData;

import java.util.List;

public interface RoleService {
    //获取角色所有权限
    public List<PermissionEntity> findPermissionListByRoleID(String roleid);
    //添加角色
    public void save(PageData pd);

    //添加橘色用户
    public void addRoleUser(PageData pd);

}
