package com.xzwb123.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "RegisterSeccess",
        urlPatterns = {"/registerSeccess"}
)
public class RegisterSeccess extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>注册成功</h1>");
        int uid = (Integer)req.getAttribute("uid");
        out.printf("<h2>您的账号是: <b>%d</b></h2>%n", uid);
        out.println("<a href=\"http://localhost:8080/maven/loginPage\">返回登录界面</a>");
    }
}
