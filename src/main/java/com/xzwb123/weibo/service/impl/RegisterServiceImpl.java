package com.xzwb123.weibo.service.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.dao.impl.RegisterDaoImpl;
import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
    RegisterDao rd = (RegisterDao) new RegisterDaoImpl();
    @Override
    public User judgeRegisterService(User user) {
        return rd.judgeRegisterDao(user);
    }
}
