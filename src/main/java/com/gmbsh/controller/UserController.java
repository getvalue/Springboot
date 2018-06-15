package com.gmbsh.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gmbsh.Entity.UserEntity;
import com.gmbsh.controller.base.BaseController;
import com.gmbsh.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户类
 * @author shil
 * @date 2018/6/14 17:39
 */
@Api(value = "API - UserController")
@RestController
public class UserController extends BaseController {
    /**注入service服务对象*/
    @Autowired
    private UserService userService;

    /**
     * 分页访问示例 设置分页请求
     *访问地址：http://localhost:8081/userlist?pageNum=2&pageSize=10
     * @param request
     * @param pageNum 第几页
     * @param pageSize 每页信息条数
     * @return
     */
    @ApiOperation(value = "用户列表",notes ="用户分页列表",httpMethod = "GET",consumes = "application/json",response = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "pageSize",value = "每页信息条数", required = true, dataType = "Integer", paramType = "query")})
    @RequestMapping(value = "userlist",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String  userList(HttpServletRequest request,Integer pageNum,Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> list = userService.findAll();//startpage后面的第一个查询是分页查询
        PageInfo pageInfo = new PageInfo(list);
        UserEntity user = userService.findOne("2");//该查询不是分页查询
        Map data = new HashMap();
        data.put("oneuser", user);
        data.put("pageinfo",pageInfo);
        return JSON.toJSONString(data) ;
    }

    /**
     * 查询单个用户信息在后面追加信息为id
     * @param id 用户ID
     * @return
     */
    @ApiOperation(value = "根据id查找", notes = "查询单个用户信息",httpMethod = "GET",consumes = "application/json", response = String.class)
    @ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "用户ID",required = true, dataType = "Integer", paramType = "path") })
    @RequestMapping(value = "userone/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String UserOne(@PathVariable String id) {
        return JSON.toJSONString(userService.findOne(id));
    }
}

