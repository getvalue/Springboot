package com.gmbsh.service;


import com.gmbsh.util.PageData;

import java.util.List;

/**
 * @author shil
 * @date 2018/6/20 10:02
 */
public interface PermissionService {

    List<PageData> getUserPermission(String username);
}
