package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.LoginDao;
import com.xzwb123.weibo.dao.impl.LoginDaoImpl;
import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.LoginService;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public User checkLoginService(String uname, String pwd) {
        return loginDao.checkLoginDao(uname, pwd);
    }
}
