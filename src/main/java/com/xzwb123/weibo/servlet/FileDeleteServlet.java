package com.xzwb123.weibo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(
        name = "FileDeleteServlet",
        urlPatterns = {"/delete"}
)
public class FileDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("/home/xzwb/maven/src/main/webapp/1580372321325");
        file.delete();
        System.out.println("ok");
    }
}
