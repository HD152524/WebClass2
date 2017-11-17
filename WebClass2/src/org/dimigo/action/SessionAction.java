package org.dimigo.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAction implements IAction {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession sess=req.getSession();
        if(sess.getAttribute("user")==null){
            RequestDispatcher rd = req.getRequestDispatcher("jsp/login.jsp");
            rd.forward(req,res);
        }else{
            RequestDispatcher rd = req.getRequestDispatcher("jsp/sessionInfo.jsp");
            rd.forward(req,res);
        }
    }
}
