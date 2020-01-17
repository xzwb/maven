package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.LoginService;
import com.xzwb123.weibo.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "CookieServlet",
        urlPatterns = {"/cookie"}
)
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        String name = "";
        String value = "";
        if (cookies != null) {
            for (Cookie c : cookies) {
                name = c.getName();
                value = c.getValue();
                if ("uid".equals(name)) {
                    System.out.println(value);
                    LoginService ls = new LoginServiceImpl();
                    User u = ls.checkCookieService(value);
                    if (u != null) {
                        resp.sendRedirect("/maven/homePage");
                        return;
                    }
                }
            }
        }
        resp.sendRedirect("/maven/loginPage");
    }
}
