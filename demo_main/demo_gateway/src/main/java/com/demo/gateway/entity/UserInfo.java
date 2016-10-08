package com.demo.gateway.entity;

import java.util.List;

/**
 * Created by 胡志洁 on 2016/10/8.
 */
public class UserInfo {

    public UserInfo(String userName, List<String> roleList) {
        this.userName = userName;
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    private String userName;
    private List<String> roleList;

}
