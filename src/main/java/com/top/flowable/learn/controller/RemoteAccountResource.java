package com.top.flowable.learn.controller;

import org.flowable.ui.common.model.RemoteUser;
import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.security.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class RemoteAccountResource {

    @GetMapping(value = "/rest/account", produces = "application/json")
    public UserRepresentation getAccount() {
        RemoteUser remoteUser= new RemoteUser();
        remoteUser.setFirstName("admin");
        remoteUser.setLastName("admin");
        remoteUser.setFullName("admin");
        remoteUser.setEmail("admin@qq.com");
        remoteUser.setId("admin");
        //构建用户代表类
        UserRepresentation userRepresentation = new UserRepresentation(remoteUser);
        SecurityUtils.assumeUser(remoteUser); //保证创建流程可用
        return userRepresentation;
    }
}
