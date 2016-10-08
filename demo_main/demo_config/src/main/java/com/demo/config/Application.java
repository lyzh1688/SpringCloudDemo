package com.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by 胡志洁 on 2016/9/29.
 */
@SpringBootApplication
@EnableConfigServer
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
