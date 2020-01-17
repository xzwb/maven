package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.pojo.User;

public interface LoginDao {
    User checkLoginDao(String uname, String pwd);
    User checkCookieDao(String uid);
}
