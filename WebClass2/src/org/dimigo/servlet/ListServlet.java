package org.dimigo.servlet;

import org.dimigo.VO.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ScopeServlet", urlPatterns="/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserVO> mylist = new ArrayList<UserVO>();
        for(int i=0;i<3;i++){
            UserVO tmp = new UserVO("ㅁㄴㅇㄹ"+i, "ㅎㅇㅎㅇ"+i,((char)(i+'A'))+"ㅁㄴㅇㄹ");
            mylist.add(tmp);
        }

        req.setAttribute("list", mylist);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/list.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doGet(req,res);
    }
}