package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.User;
import com.xzwb123.weibo.service.RegisterService;
import com.xzwb123.weibo.service.impl.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Register",
        urlPatterns = {"/register"}
)
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = new User();
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String phoneNumber = req.getParameter("phoneNumber");
        if (uname == null || pwd == null || phoneNumber == null) {
            req.setAttribute("NULL?", "is null");
            req.getRequestDispatcher("registerPage").forward(req, resp);
        }
        user.setUname(uname);
        user.setPassword(pwd);
        user.setPhoneNumber(phoneNumber);
        RegisterService registerService = new RegisterServiceImpl();
        user = registerService.judgeRegisterService(user);
        if (user.getUid() > 0) {
            req.setAttribute("uid", user.getUid());
            req.getRequestDispatcher("registerSeccess").forward(req, resp);
        } else {
            req.setAttribute("registerJudge", "no");
            req.getRequestDispatcher("registerPage").forward(req, resp);
        }
    }
}
