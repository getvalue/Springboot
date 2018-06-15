package com.gmbsh.Mapper;

import com.gmbsh.Entity.PermissionEntity;
import com.gmbsh.util.PageData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {


    /**
     * 查询某一个角色所有的权限
     */
    List<PermissionEntity> findPermissionByRoleID(String Role_id);

    void save(PageData pd);
}
