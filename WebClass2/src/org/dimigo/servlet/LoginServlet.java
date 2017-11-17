package org.dimigo.servlet;

import com.google.gson.Gson;
import org.dimigo.VO.UserVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet(name = "LoginServlet", urlPatterns="/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        //id, pwd 정합성 체크
        boolean result = true;

        HttpSession session = request.getSession();
        if(result){
            UserVO user = new UserVO();
            user.setId(id);
            user.setNickname("asdf");
            user.setName("ㅋㅌㅊㅍ");
            session.setAttribute("user", user);

            RequestDispatcher rd = request.getRequestDispatcher("jsp/home.jsp");
            rd.forward(request,response);
        }
        else{
            session.setAttribute("msg", "ERROR");
            RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
            rd.forward(request,response);

        }
    }
    protected void doPost2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        Gson gson = new Gson();
        Map<String, String> a = new HashMap<String, String>();
        a.put("id",id);
        out.write(gson.toJson(a));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WebClass/jsp/login.jsp");
    }
}
