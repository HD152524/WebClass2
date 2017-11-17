package org.dimigo.action;

import org.dimigo.VO.UserVO;
import org.dimigo.service.UserService;
import org.dimigo.util.CommonUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpAction implements IAction{
    public void validate(UserVO vo) throws Exception{
        if(CommonUtil.isEmpty(vo.getId())) throw new Exception("아이디를 입력해주세요.");
        if(CommonUtil.isEmpty(vo.getPwd())) throw new Exception("비밀번호를 입력해주세요.");
        if(CommonUtil.isEmpty(vo.getNickname())) throw new Exception("닉네임을 입력해주세요.");
        if(CommonUtil.isEmpty(vo.getName())) throw new Exception("이름을 입력해주세요.");

    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("utf-8");
        try {
            String id = req.getParameter("id");
            String pwd = req.getParameter("pwd");
            String name = req.getParameter("name");
            String nickname = req.getParameter("nickname");

            System.out.println("id: " + id);
            System.out.println("pwd: " + pwd);
            System.out.println("name: " + name);
            System.out.println("nickname: " + nickname);

            UserVO user = new UserVO(id, name, nickname, pwd);

            validate(user);

            UserService service = new UserService();
            service.signup(user);

            RequestDispatcher rd = req.getRequestDispatcher("jsp/login.jsp");
            rd.forward(req, res);
        }
        catch(Exception e){
            e.printStackTrace();
            req.setAttribute("error",e.getMessage());
            RequestDispatcher rd = req.getRequestDispatcher("jsp/signup.jsp");
            rd.forward(req,res);
        }
    }
}
