package com.chunjae.test05.biz;

import com.chunjae.test05.entity.User;
import com.chunjae.test05.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public User getUser(String eName) {
        return userMapper.getUser(eName);
    }

    @Override
    public User getByEmail(String email) {
        return userMapper.getByEmail(email);
    }

    @Override
    public User getByName(String eName) {
        return userMapper.getByName(eName);
    }

    @Override
    public User findById(String email, String tel) {
        return userMapper.findById(email, tel);
    }

    @Override
    public User findByPw(String email, String tel, String eName) {
        return userMapper.findByPw(email, tel, eName);
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int getWithdraw(Integer id) {
        return userMapper.getWithdraw(id);
    }

    @Override
    public int getActivate(String eName) {
        return userMapper.getActivate(eName);
    }

    @Override
    public int getDormant(String eName) {
        return userMapper.getDormant(eName);
    }

    @Override
    public int userUpdateInfo(User user) {
        return userMapper.userUpdateInfo(user);
    }
    @Override
    public int userUpdatePw(User user) {
        return userMapper.userUpdatePw(user);
    }
    @Override
    public int userUpdatePoint(User user) {
        return userMapper.userUpdatePoint(user);
    }
    @Override
    public int userJoin(User user) {
        return userMapper.userJoin(user);
    }
    @Override
    public int userLevUpdate(String eName, String lev) {
        return userMapper.userLevUpdate(eName, lev);
    }
    @Override
    public int removeUser(String eName) {
        return userMapper.removeUser(eName);
    }
    @Override
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
