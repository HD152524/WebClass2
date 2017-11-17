package org.dimigo.action;

import org.dimigo.VO.UserVO;
import org.dimigo.util.CommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutAction implements IAction{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();

        RequestDispatcher rd = req.getRequestDispatcher("jsp/home.jsp");
        rd.forward(req,res);


    }
}
