package com.xzwb123.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "UpLoadFile",
        urlPatterns = {"/upPage"}
)
public class UpLoadFile extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<form action='up' method='post' enctype='multipart/form-data'>");
        out.println("<input type='file' accept=\"image/png, image/jpeg, image/gif, image/jpg\" name='img'>");
        out.println("<input type='submit' value='上传'>");
        out.println("</form>");
    }
}
