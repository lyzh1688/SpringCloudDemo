package com.demo.gateway.api.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by 胡志洁 on 2016/9/30.
 */
@FeignClient("role")
public interface IRole {
    @RequestMapping(value = "/getUserRole/{userId}",method = RequestMethod.GET)
    List<String> getUserRole(@PathVariable("userId") String userId);
}
