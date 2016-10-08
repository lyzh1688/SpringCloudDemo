package com.demo.role;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胡志洁 on 2016/9/29.
 */
@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
public class Application {

    @Value("${db.username:username}")
    String dbUserName ;

    @RequestMapping("/")
    public String home(){
        return "Hello " + dbUserName;
    }

    @RequestMapping(value = "/getUserRole/{userId}",method = RequestMethod.GET)
    public List<String> getUserRole(@PathVariable  String userId){
        List roleList = new ArrayList<String>();
        roleList.add("admin");
        roleList.add("DEVELOPER");
        return roleList;
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
