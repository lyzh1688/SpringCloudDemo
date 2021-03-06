package com.demo.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by 胡志洁 on 2016/9/29.
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}
