package com.xzwb123.question.servlet;

import com.xzwb123.question.service.QuestionService;
import com.xzwb123.question.service.impl.QuestionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(
        name = "QuestionPage",
        urlPatterns = {"/questionPage"}
)
public class QuestionPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String judge = (String)req.getAttribute("judge");
        out.println("<form action=\"questionPage\" method=\"post\">");
        if (judge != null) {
            req.removeAttribute("judge");
            out.println("<h1>把每一个空空都填了</h1>");
            page1(out);
        }
        String page = req.getParameter("page");
        Map<String, String> qAndA = new HashMap<>();
        if (page == null) {
            page1(out);
        } else if ("page2".equals(page)) {
            page2(req, out);
        } else if ("finish".equals(page)) {
            if (finishPage(req, out, qAndA)) {
                resp.sendRedirect("/maven/homePage");
            } else {
                req.setAttribute("judge", "no");
                req.getRequestDispatcher("questionPage").forward(req, resp);
            }
        }
    }

    private void page1(PrintWriter out) {
        out.println("请输入您的姓名本次问卷实名制!!!<input type='text' name='uname'><br>");
        out.println("问题一:魔镜魔镜谁是世界上最帅的人 <input type='text' name='p1q1'><br><br>");
        out.println("问题二:魔镜魔镜谁是世界上最傻的人 <input type='text' name='p1q2'><br><br>");
        out.println("<input type='submit' name='page' value='page2'>");
    }

    private void page2(HttpServletRequest req, PrintWriter out) {
        out.println("究极问题三(送命题)你觉得你的对象好看还是吴亦凡(迪丽热巴)好看阐述理由:<input type='text' name='p2q1'><br>");
        out.printf("<input type='hidden' name='uname' value='%s'>%n", req.getParameter("uname"));
        out.printf("<input type='hidden' name='p1q1' value='%s'>%n", req.getParameter("p1q1"));
        out.printf("<input type='hidden' name='p1q2' value='%s'>%n", req.getParameter("p1q2"));
        out.println("<input type='submit' name='page' value='finish'>");
    }

    private boolean finishPage(HttpServletRequest req, PrintWriter out, Map<String, String> qAndA) {
        qAndA.put("p2q1", (String)req.getParameter("p2q1"));
        qAndA.put("uname", (String)req.getParameter("uname"));
        qAndA.put("p1q1", (String)req.getParameter("p1q1"));
        qAndA.put("p1q2", (String)req.getParameter("p1q2"));
        QuestionService questionService = new QuestionServiceImpl();

        return questionService.questionService(qAndA);
    }
}
