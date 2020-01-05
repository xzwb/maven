package com.xzwb.servlet.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "ForwardOne",
        urlPatterns = {"/forward1"}
)
public class ForwardOne extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String judge = (String)req.getAttribute("judge");
        if (judge == null) {
            out.println("<form action=\"forward2\" method=\"post\">\n" +
                    "    用户名：<input type=\"text\" name=\"uname\" value=\"\"><br>\n" +
                    "    密码：<input type=\"password\" name=\"pwd\" value=\"\"><br>\n" +
                    "    <input type=\"submit\" value=\"login\">\n" +
                    "</form>");
        } else if("success".equals(judge)) {
            out.println("欢迎" + req.getParameter("uname") + "登录");
        } else {
            out.println("用户名或密码错误");
            out.println("<form action=\"forward2\" method=\"post\">\n" +
                    "    用户名：<input type=\"text\" name=\"uname\" value=\"\"><br>\n" +
                    "    密码：<input type=\"password\" name=\"pwd\" value=\"\"><br>\n" +
                    "    <input type=\"submit\" value=\"login\">\n" +
                    "</form>");
        }
    }
}
