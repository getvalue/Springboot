package com.gmbsh.Mapper;

import com.alibaba.fastjson.JSONObject;
import com.gmbsh.util.PageData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shil
 * @date 2018/6/20 10:24
 */
@Mapper
public interface PermissionMapper {
    List<PageData> getUserPermission(String username);
}
