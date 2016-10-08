package com.demo.gateway.api.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 胡志洁 on 2016/10/8.
 */
@FeignClient("user")
public interface IUser {
    @RequestMapping(value = "/getUserName",method = RequestMethod.GET)
    public String getUserName();
}
