package com.chunjae.test03.biz;

import com.chunjae.test03.entity.User;
import com.chunjae.test03.persistence.UserMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    HttpSession session;

    @Override
    public List<User> userList() throws Exception {
        return userMapper.userList();
    }

    @Override
    public User userGet(String eName) throws Exception {
        return userMapper.userGetByEName(eName);
    }

    @Override
    public Boolean userGetByEName(User user) throws Exception {

        boolean pass = false;

        User member = userMapper.userGetByEName(user.getEName());
        if(member != null && member.getEPassword().equals(user.getEPassword())) {
            session.setAttribute("sid", member.getEName());
            session.setAttribute("level", member.getLev());
            pass = true;
        }

        return pass;
    }

    @Override
    public Boolean userGetByEmail(User user) throws Exception {

        boolean pass = false;

        User member = userMapper.userGetByEmail(user.getEmail());
        if(member != null && member.getEPassword().equals(user.getEPassword())) {
            session.setAttribute("sid", member.getEName());
            pass = true;
        }

        return pass;
    }

    @Override
    public User userFindById(User user) throws Exception {
        return userMapper.userFindById(user);
    }

    @Override
    public User userFindByPw(User user) throws Exception {
        return userMapper.userFindByPw(user);
    }

    @Override
    public int userInsert(User user) throws Exception {
        int cnt = userMapper.userInsert(user);
        return cnt;
    }

    @Override
    public void userActWithdrawUpdate(String eName) throws Exception {
        userMapper.userActWithdrawUpdate(eName);
        session.invalidate();
    }

    @Override
    public void userActDormantUpdate(String eName) throws Exception {
        userMapper.userActDormantUpdate(eName);
    }

    @Override
    public void userActJoinUpdate(String eName) throws Exception {
        userMapper.userActJoinUpdate(eName);
    }

    @Override
    public int userInfoUpdate(User user) throws Exception {
        int cnt = userMapper.userInfoUpdate(user);
        return cnt;
    }

    @Override
    public void userPwUpdate(User user) throws Exception {
        userMapper.userPwUpdate(user);
    }

    @Override
    public void userPointUpdate(User user) throws Exception {
        userMapper.userPointUpdate(user);
    }

    @Override
    public void userLevUpdate(User user) throws Exception {
        userMapper.userLevUpdate(user);
    }

    @Override
    public int userDelete(String eName) throws Exception {
        int cnt = userMapper.userDelete(eName);
        return cnt;
    }
}