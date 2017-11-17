package org.dimigo.action;

import org.dimigo.VO.UserVO;
import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginAction implements IAction{
    //입력값 검증용 메서드
    private void validate(String id, String pwd) throws Exception{
        if(CommonUtil.isEmpty(id))
            throw new Exception("ID를 입력하세요");
        if(CommonUtil.isEmpty(pwd))
            throw new Exception("비밀번호를 입력하세요.");
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            //1. 입력값 확인
            System.out.printf("id : %s, pwd: %s\n", id, pwd);

            validate(id, pwd);

            UserVO user = new UserVO();
            user.setId(id);
            user.setPwd(pwd);


            UserService service = new UserService();
            UserVO result = service.login(user);

            HttpSession session = req.getSession();
            session.setAttribute("user",result);
            RequestDispatcher rd = req.getRequestDispatcher("jsp/home.jsp");
            rd.forward(req, res);
        }
        catch(Exception e){
            e.printStackTrace();
            req.setAttribute("error",e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("jsp/login.jsp");
            rd.forward(req,res);
        }
    }
}
