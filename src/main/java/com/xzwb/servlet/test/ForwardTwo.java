package com.xzwb.servlet.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "ForwardTwo",
        urlPatterns = {"/forward2"}
)
public class ForwardTwo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("uname : " + uname + "pwd : " + pwd);
        if ("xzwb".equals(uname)) {
            req.setAttribute("judge", "success");
        } else {
            req.setAttribute("judge", "fail");
        }
        req.getRequestDispatcher("forward1").forward(req, resp);
    }
}
