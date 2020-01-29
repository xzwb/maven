package com.xzwb123.weibo.dao;

import com.xzwb123.weibo.pojo.FileA;

import java.sql.*;

public class FileDao {
    public FileA fileDao(String fid) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        FileA fileA = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weibo2_0?characterEncoding=utf8", "root", "520520cw...");
            String sql = "select *from t_file where fid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, fid);
            rs = ps.executeQuery();
            while (rs.next()) {
                fileA = new FileA();
                fileA.setFid(rs.getInt("fid"));
                fileA.setUid(rs.getInt("uid"));
                fileA.setTxt(rs.getString("txt"));
                fileA.setUname(rs.getString("uname"));
                fileA.setTimestamp(rs.getTimestamp("savaTime"));
                fileA.setBlob(rs.getBlob("bytes"));
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
        return fileA;
    }
}
