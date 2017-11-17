package org.dimigo.service;

import org.dimigo.VO.UserVO;
import org.dimigo.dao.UserDao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class UserService extends AbstractService{
    public UserVO login(UserVO user) throws Exception{
        Connection conn = null;
        try{
            conn = getConnection();

            UserDao dao = new UserDao(conn);
            UserVO result = dao.searchUser(user);

            if(result == null)
                throw new Exception("Invalid Username Or PWD");
            else
                return result;
        }
        finally{
            if(conn!=null)
                conn.close();
        }
    }
    public List<UserVO> searchUserList() throws Exception{
        //DB에서 사용자 목록 조회

        Connection conn = null;
        try{
            conn=getConnection();
            UserDao dao = new UserDao(conn);
            List<UserVO> result = dao.searchUserList();
            return result;
        }
        finally{
            if(conn!=null)
                conn.close();
        }

    }
    public void signup(UserVO user) throws Exception{
        Connection conn = null;
        try{
            conn = getConnection();

            UserDao dao = new UserDao(conn);
            UserVO result = dao.searchUserById(user);
            if(result != null)
                throw new Exception("이미 사용중인 아이디 입니다.");

            //사용자 등록
            dao.insertUser(user);
        }
        finally{
            if(conn!=null) conn.close();
        }
    }
}
