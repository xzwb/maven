package com.xzwb123.weibo.dao.impl;

import com.xzwb123.weibo.dao.LoginDao;
import com.xzwb123.weibo.pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User checkLoginDao(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo","root","520520cw...");
            String sql = "select *from t_user where uname = ? and pwd = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("pwd"));
            }
        } catch (Exception e) {
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
