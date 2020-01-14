package com.xzwb123.weibo.service;

import com.xzwb123.weibo.pojo.User;

public interface LoginService {
    User checkLoginService(String uname, String pwd);
}
