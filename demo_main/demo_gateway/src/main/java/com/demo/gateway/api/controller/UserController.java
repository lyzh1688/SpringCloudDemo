package com.demo.gateway.api.controller;

import com.demo.gateway.api.service.UserService;
import com.demo.gateway.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 胡志洁 on 2016/10/8.
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;
    @RequestMapping("/getUserInfo")
    public UserInfo getUserInfo() {
        return this.userService.getUserInfo();
    }
}
