package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.RegisterDao;
import com.xzwb123.weibo.pojo.User;


import java.sql.*;

public class RegisterDaoImpl implements RegisterDao {
    @Override
    public User judgeRegisterDao(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo", "root", "520520cw...");
            String sql = "select *from t_user where phoneNUmber = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPhoneNumber());
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getString("uname") == null) {
                    user.setUid(-1);
                    return user;
                }
            }
            String sql1 = "insert into t_user values(default, ?, ?, ?)";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, user.getUname());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhoneNumber());
            ps.executeUpdate();
            String sql2 = "select uid from t_user where phoneNumber = ?";
            ps = conn.prepareStatement(sql2);
            ps.setString(1, user.getPhoneNumber());
            rs = ps.executeQuery();
            if (rs.next()) {
                user.setUid(rs.getInt("uid"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
