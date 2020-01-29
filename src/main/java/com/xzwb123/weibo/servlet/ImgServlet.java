package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.service.FileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

@MultipartConfig
@WebServlet(
        name = "ImgServlet",
        urlPatterns = {"/img"}
)
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Part part = req.getPart("img");
        InputStream in = part.getInputStream();
        FileService fs = new FileService();
        fs.fileService(in);
        System.out.println("ok");
    }
}
