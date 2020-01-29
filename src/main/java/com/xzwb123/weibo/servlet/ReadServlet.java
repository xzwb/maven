package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.dao.FileDao;
import com.xzwb123.weibo.pojo.FileA;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * 读取数据库中的图片
 */
@WebServlet(
        name = "ReadServlet",
        urlPatterns = {"/readFile"}
)
public class ReadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        // resp.getWriter().println("<h1>哈哈哈</h1><br><hr>");
        FileDao fd = new FileDao();
        FileA fileA = fd.fileDao("2");
        Blob blob = fileA.getBlob();
        try {
            byte[] bytes = blob.getBytes(1L, (int)blob.length());
            resp.setContentType("image/gif;");
            ServletOutputStream op = resp.getOutputStream();
            op.write(bytes);
            op.flush();
            op.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
