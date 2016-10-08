package com.demo.gateway.api.feign;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胡志洁 on 2016/10/8.
 */
@Component
public class UserClient {

    @Autowired
    private IUser userClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String getUserName(){
        return this.userClient.getUserName();
    }

    public String fallback(){
        return "Yuezy";
    }
}
