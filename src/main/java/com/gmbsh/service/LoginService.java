package com.gmbsh.service;

import com.alibaba.fastjson.JSONObject;
import com.gmbsh.util.PageData;

import java.util.List;

/**
 * @author shil
 * @date 2018/6/20 0:34
 */
public interface LoginService {
    /**用户登陆*/
    PageData getUser(PageData pd);

    PageData  getInfo();

    PageData logout();
}
