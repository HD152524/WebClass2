package org.dimigo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignupServlet", urlPatterns="/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String nickname= request.getParameter("nickname");

        System.out.println("id: "+id);
        System.out.println("pwd: "+pwd);
        System.out.println("name: "+name);
        System.out.println("nickname: "+nickname);

        boolean result = false;
        if (result) {
            response.sendRedirect("jsp/login.jsp");
        }else{
            request.setAttribute("msg", "Error");
            RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
            rd.forward(request,response);
        }
    }
}
