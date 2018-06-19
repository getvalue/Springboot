package com.gmbsh.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gmbsh.Entity.UserEntity;
import com.gmbsh.controller.base.BaseController;
import com.gmbsh.service.LoginService;
import com.gmbsh.service.RoleService;
import com.gmbsh.util.PageData;
import com.gmbsh.util.UuidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * 登录类
 * @author shil
 * @date 2018/6/14 17:39
 */
@Api(value = "API - LoginController")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private LoginService loginService;

    @Value(value = "${server.port}")
    String port;
    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    @ApiOperation(value = "用户登录",notes ="用户登录接口",httpMethod = "POST",consumes = "application/json",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userInfo", value = "用户信息",required = true, dataType = "UserEntity", paramType = "query")
    })
    @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
    public String ajaxLogin(UserEntity userInfo) {
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        subject.getSession();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(), userInfo.getPassword());
        try {
            subject.login(token);
            jsonObject.put("token", subject.getSession().getId());
            jsonObject.put("msg", "登录成功");
        } catch (IncorrectCredentialsException e) {
            jsonObject.put("msg", "密码错误");
        } catch (LockedAccountException e) {
            jsonObject.put("msg", "登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            jsonObject.put("msg", "该用户不存在");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    /**
     * 登录方法
     * @param roleid
     * @return
     */
    @ApiOperation(value = "查询权限",notes ="查询权限接口",httpMethod = "POST",consumes = "application/json",response = String.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "roleid", value = "角色ID",required = true, dataType = "String", paramType = "query")})
    @RequestMapping(value = "/ajaxRole", method = RequestMethod.POST)
    public String ajaxRole(String roleid) {
        roleid = roleid != null && !roleid.isEmpty() ? roleid : "2";
        JSONArray js = new JSONArray();
        js.addAll(roleService.findPermissionListByRoleID(roleid));
        return js.toString();
    }

}

