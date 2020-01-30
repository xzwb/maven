package com.xzwb123.weibo.service;

import com.xzwb123.weibo.pojo.NewFile;

import java.sql.*;

public class NewFileService {
    public void newFileService(NewFile file) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "insert into t_file values(default, 1, 'xzwb', 'xxx', default, ?, 1)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, file.getFilename());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ;
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
