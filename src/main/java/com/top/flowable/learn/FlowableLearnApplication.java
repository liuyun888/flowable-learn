package com.top.flowable.learn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * 排除Spring security的拦截，如果不排除会跳转到登录页面进行登录
 * exclude = {SecurityAutoConfiguration.class}
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FlowableLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowableLearnApplication.class, args);
    }

}
