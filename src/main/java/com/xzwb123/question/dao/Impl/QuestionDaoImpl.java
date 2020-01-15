package com.xzwb123.question.dao.Impl;

import com.xzwb123.question.dao.QuestionDao;

import java.sql.*;
import java.util.Map;

public class QuestionDaoImpl implements QuestionDao {
    @Override
    public void questionDao(Map<String, String> qAndA) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/question?characterEncoding=utf8", "root", "520520cw...");
            String sql = "insert into qAndA values(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, qAndA.get("uname"));
            ps.setString(2, qAndA.get("p1q1"));
            ps.setString(3, qAndA.get("p1q2"));
            ps.setString(4, qAndA.get("p2q1"));
            ps.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
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
    }
}
