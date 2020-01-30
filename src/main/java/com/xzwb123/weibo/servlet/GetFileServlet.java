package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.NewFile;
import com.xzwb123.weibo.service.GetUrl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "GetFileServlet",
        urlPatterns = {"/get"}
)
public class GetFileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        GetUrl getUrl = new GetUrl();
        NewFile newFile = getUrl.getUrl("7");
        System.out.println(newFile.getFilename());
        out.println("<img src = '" + newFile.getFilename() + "' width='200px'>" );

        // out.println("<img src=\"1580372321325\" width=\"128px\" alt=\"微博\">");
    }
}
