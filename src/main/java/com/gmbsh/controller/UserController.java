package com.gmbsh.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gmbsh.Entity.UserEntity;
import com.gmbsh.service.UserService;
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

@RestController
public class UserController {
    //注入service服务对象
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
    @RequestMapping(value = "userlist",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String  userList(HttpServletRequest request, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<UserEntity> list = userService.findAll();//startpage后面的第一个查询是分页查询
        PageInfo pageInfo = new PageInfo(list);
        UserEntity user = userService.findOne("2");//该查询不是分页查询
        Map data = new HashMap();
        data.put("oneuser", user);
        data.put("pageinfo",pageInfo);
        return "PageInfo: " + JSON.toJSONString(data) ;
//        + ", Page: " + JSON.toJSONString(page)
    }

    /**
     * 查询单个用户信息在后面追加信息为id
     * @param id 用户ID
     * @return
     */
    @RequestMapping(value = "userone/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String UserOne(@PathVariable String id) {
        return JSON.toJSONString(userService.findOne(id));
    }
}

