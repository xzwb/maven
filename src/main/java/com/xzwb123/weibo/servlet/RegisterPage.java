package com.xzwb123.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "RegisterPage",
        urlPatterns = {"/registerPage"}
)
public class RegisterPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String judge = (String)req.getAttribute("registerJudge");
        String isnull = (String)req.getAttribute("NULL?");
        if (isnull != null) {
            out.println("<h1>请完善所有信息</h1>");
        }
        if (judge != null) {
            out.println("<h1>该手机号已经注册过微博了</h1>");
        }
        req.removeAttribute("registerJudge");
        req.removeAttribute("NULL?");
        out.println("<h1>请完善以下信息</h1>");
        out.println("<form action=\"register\" method=\"post\">\n" +
                "    用户名：<input type=\"text\" name=\"uname\" value=\"\"><br>\n" +
                "    密码：<input type=\"password\" name=\"pwd\" value=\"\"><br>\n" +
                "    手机号:<input type=\"text\" name=\"phoneNumber\" value=\"\"><br>\n"+
                "    <input type=\"submit\" value=\"login\">\n" +
                "</form>");
    }
}
