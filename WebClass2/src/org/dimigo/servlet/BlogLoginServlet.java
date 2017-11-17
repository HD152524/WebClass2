package org.dimigo.servlet;

import org.dimigo.VO.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "BlogLoginServlet", urlPatterns="/bloglogin")
public class BlogLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        //id, pwd 정합성 체크

        HttpSession session = request.getSession();
        if(id.equals("test@naver.com")){
            UserVO user = new UserVO();
            user.setId(id);
            user.setNickname("사용자 닉네임");
            user.setName("사용자 이름");
            session.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("/myblog/index.jsp");
            rd.forward(request,response);
        }
        else{
            request.setAttribute("msg", "ERROR");
            RequestDispatcher rd = request.getRequestDispatcher("/myblog/login.jsp");
            rd.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WebClass/jsp/login.jsp");
    }
}
