package com.github.acl.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.acl.service.LoginLogoutService;
import com.github.utils.ResultCommon;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author HAN
 * @version 1.0
 * @create 04-26-16:13
 */
@RestController
@RequestMapping("acl/index")
@Api("security控制器")
public class LoginLogoutController {

    @Autowired
    private LoginLogoutService loginLogoutService;

    /**
     * 获取user数据
     */
    @GetMapping("info")
    @ApiOperation("获取用户数据")
    public ResultCommon getUserInfo() {
        // 获取登陆的用户
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Map<String, Object> map = loginLogoutService.getUserInfo("admin");
        return ResultCommon.success().setData(map);
    }

    /**
     * 获得可访问菜单列表
     */
    @GetMapping("menu")
    @ApiOperation("获得菜单列表")
    public ResultCommon getMenu() {
        // 获取登陆的用户
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<JSONObject> permissions = loginLogoutService.getMenu("admin"); // todo
        return ResultCommon.success();
    }
}