package com.gmbsh.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gmbsh.Mapper.UserMapper;
import com.gmbsh.service.LoginService;
import com.gmbsh.service.PermissionService;
import com.gmbsh.util.CommonUtil;
import com.gmbsh.util.Const;
import com.gmbsh.util.PageData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shil
 * @date 2018/6/20 0:37
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermissionService permissionService;
    @Override
    public PageData getUser(PageData pd) {
        return  userMapper.loginOne(pd);
    }
    /**
     * 查询当前登录用户的权限等信息
     *
     * @return
     */
    @Override
    public PageData getInfo() {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        PageData userInfo = (PageData) session.getAttribute(Const.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        JSONObject returnData = new JSONObject();
        List<PageData> userPermission = permissionService.getUserPermission(username);
        session.setAttribute(Const.SESSION_USER_PERMISSION, userPermission);
        returnData.put("userPermission", userPermission);
        PageData pd = new PageData();
        return    CommonUtil.successpd(returnData);
    }

    @Override
    public PageData logout() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.removeAttribute(Const.SESSION_USER_INFO);
        session.removeAttribute(Const.SESSION_USER_PERMISSION);
        subject.logout();
        PageData pd = new PageData();
        pd.put("msg", "退出成功");
        return  CommonUtil.successpd(pd);
    }

}

