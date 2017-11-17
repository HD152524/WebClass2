package org.dimigo.action;

import org.dimigo.VO.UserVO;
import org.dimigo.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ListAction implements IAction{
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        UserService service = new UserService();
        List<UserVO> mylist = service.searchUserList();
        req.setAttribute("list", mylist);

        RequestDispatcher rd = req.getRequestDispatcher("jsp/list.jsp");
        rd.forward(req,res);
    }
}
