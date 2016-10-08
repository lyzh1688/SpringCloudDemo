package com.demo.gateway.api.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胡志洁 on 2016/10/8.
 */

@Component
public class RoleClient {

    @Autowired
    private IRole roleClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public List<String> getUserRole(String userId){
        return this.roleClient.getUserRole(userId);
    }

    public List<String> fallback(String userId){
        List<String> defaultRole = new ArrayList<String>();
        defaultRole.add("Default");
        return defaultRole;
    }
}
