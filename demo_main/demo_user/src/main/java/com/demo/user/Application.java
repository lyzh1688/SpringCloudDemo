package com.demo.user;


import com.demo.user.feign.IRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by 胡志洁 on 2016/9/29.
 */
@SpringBootApplication
@RestController
@RefreshScope
@EnableEurekaClient
@EnableFeignClients
public class Application {

    @Value("${db.username:username}")
    String dbUserName ;

    @RequestMapping("/")
    public String home(){
        return "Hello " + dbUserName;
    }

    @Autowired
    RestTemplate client;

    @Autowired
    IRole roleClient;
    /**
     * LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
     *
     * @return
     */

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate template = new RestTemplate();
        SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return template;
    }


    @RequestMapping("/getUserRole")
    public List<String> getUserRole() {
        return client.getForObject("http://role/getUserRole/1", List.class);
    }


    @RequestMapping("/getUserRole2")
    public List<String> getUserRole2() {
        return roleClient.getUserRole("1");
    }

    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
