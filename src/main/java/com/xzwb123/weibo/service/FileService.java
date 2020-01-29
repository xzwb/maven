package com.xzwb123.weibo.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class FileService {
    public void fileService(InputStream in) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "insert into t_file values(default, 1, 'xzwb', 'www', default, ?, 1)";
            ps = conn.prepareStatement(sql);
            ps.setBinaryStream(1, in);
            ps.executeUpdate();
        } catch (Exception e) {
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
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
