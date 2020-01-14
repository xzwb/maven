package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.LoginService;
import com.xzwb123.weibo.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Login",
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        LoginService ls = new LoginServiceImpl();
        User user = ls.checkLoginService(uname, pwd);
        if (user == null) {
            request.setAttribute("judge", "no");
            request.getRequestDispatcher("loginPage").forward(request, response);
        } else {
            response.sendRedirect("/maven/homePage");
        }
    }
}
