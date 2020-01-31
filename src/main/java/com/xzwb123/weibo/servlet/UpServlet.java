package com.xzwb123.weibo.servlet;

import com.xzwb123.weibo.pojo.NewFile;
import com.xzwb123.weibo.service.NewFileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Calendar;

@MultipartConfig(location = "/home/xzwb/maven/src/main/webapp")
@WebServlet(
        name = "UpServlet",
        urlPatterns = {"/up"}
)
public class UpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /*String h = req.getParameter("img");
        System.out.println(h);*/
        Part part = req.getPart("img");
        /*if (part == null) {
            System.out.println("xxx");
        } else {
            System.out.println("yyy");
        }*/
        /*String filename = part.getHeader("Content-Disposition");
        System.out.println(filename);*/
        String filename = part.getSubmittedFileName();
        if ("".equals(filename)) {
            System.out.println("xzzz");
        } else {
            System.out.println("ccc");
        }
        // System.out.println(f);
        /*String f1 = part.getName();
        System.out.println(f1);*/
//        long timeInMillis = Calendar.getInstance().getTimeInMillis();
//        filename = timeInMillis + ""/*+ filename*/;
//        // System.out.println(filename);
//        String url = /*req.getSession().getServletContext().getRealPath("")*/  filename;
//        try {
//            part.write(String.format("%s", url));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        NewFile newFile = new NewFile();
//        newFile.setFilename(url);
//        NewFileService newFileService = new NewFileService();
//        newFileService.newFileService(newFile);
    }
}