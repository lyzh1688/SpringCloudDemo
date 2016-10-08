package com.demo.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 胡志洁 on 2016/10/8.
 */
@RestController
public class UserController {

    @RequestMapping("/getUserName")
    public String getUserName() {
        return "Liu YueZhi";
    }
}
