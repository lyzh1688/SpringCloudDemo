package com.demo.gateway.api.service;

import com.demo.gateway.api.feign.IRole;
import com.demo.gateway.api.feign.IUser;
import com.demo.gateway.api.feign.RoleClient;
import com.demo.gateway.api.feign.UserClient;
import com.demo.gateway.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 胡志洁 on 2016/10/8.
 */
@Service
public class UserService {

    @Autowired
    RoleClient roleClient;

    @Autowired
    UserClient userClient;

    public UserInfo getUserInfo (){
        String userName = this.userClient.getUserName();
        List<String> roleList = this.roleClient.getUserRole("000881815");
        return new UserInfo(userName,roleList);
    }

}
