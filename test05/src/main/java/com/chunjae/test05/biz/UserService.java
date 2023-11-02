package com.chunjae.test05.biz;

import com.chunjae.test05.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface UserService {

    public List<User> getUserList();
    public User getUser(String eName);
    public User getByEmail(String email);
    public User getByName(String eName);
    public User findById(String email, String tel);
    public User findByPw(String email, String tel, String eName);
    public User getUserById(Long id);
    public int getWithdraw(Integer id);
    public int getActivate(String eName);
    public int getDormant(String eName);
    public int userUpdateInfo(User user);
    public int userUpdatePw(User user);
    public int userUpdatePoint(User user);
    public int userJoin(User user);
    public int userLevUpdate(String eName, String lev);
    public int removeUser(String eName);

    public PasswordEncoder passwordEncoder();

}