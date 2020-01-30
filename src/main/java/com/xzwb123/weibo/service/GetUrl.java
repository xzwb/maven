package com.xzwb123.weibo.service;

import com.xzwb123.weibo.pojo.NewFile;

import java.sql.*;

public class GetUrl {
    public NewFile getUrl(String fid) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        NewFile newFile = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_file where fid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                newFile = new NewFile();
                newFile.setFilename(rs.getString("url"));
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
        return newFile;
    }
}
