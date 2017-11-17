package org.dimigo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ScopeServlet", urlPatterns="/scope")
public class ScopeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            System.out.printf("id: %s, pwd: %s \n", id, pwd);

            if (id == null || id.trim().equals(""))
                throw new Exception("아이디는 필수 항목입니다.");

            //1. Request Scope
            req.setAttribute("key", "rValue");

            //2. Session Scope
            req.getSession().setAttribute("key", "sValue");

            //3. Application Scope
            getServletContext().setAttribute("key", "aValue");

            RequestDispatcher rd = req.getRequestDispatcher("jsp/scope.jsp");
            rd.forward(req, res);
        }catch(Exception e){
            req.setAttribute("error", e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("jsp/scope.jsp");
            rd.forward(req, res);
        }
    }
}