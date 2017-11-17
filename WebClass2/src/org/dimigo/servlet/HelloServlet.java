package org.dimigo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.printf("id: %s, Name: %s", id, name);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter a = response.getWriter();
        a.println("<!DOCTYPE html><html><head><title>Servlet Test</title></head><body><h1>Hello, Servlet</h1>");
        a.println("<h2>id : "+id+"name: "+name+"</h2>");
        a.println("</body></html>");
        a.close();
        // Content Type설정
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("INIT()");
    }
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        System.out.println("service()");
        super.service(req,res);
    }

    @Override
    public void destroy() {
        System.out.println("destroy()");
    }
}
