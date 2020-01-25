package com.xzwb123.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletConfig学习.不仅可以取到标注中的,还可以取到web.xml中的
 */
@WebServlet(
        name = "ConfigServlet",
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name", value = "value")
        }
)
public class ConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = getInitParameter("name");
        System.out.println(value);
    }
}
