package org.dimigo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "SessionServlet", urlPatterns="/session")
public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //세션에 사용자 정보 O 확인하고
        // 없으면 jsp/login.jsp 포워딩
        // 있으면 jsp/sessioninfo.jsp로 포워딩(id, name, nickname을 출력)
        HttpSession sess=request.getSession();
        if(sess.getAttribute("user")==null){
            response.sendRedirect("jsp/login.jsp");
            /*RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
            rd.forward(request,response);*/
        }else{
            RequestDispatcher rd = request.getRequestDispatcher("jsp/sessionInfo.jsp");
            rd.forward(request,response);
        }
    }
}
