package com.chunjae.test04.biz;

import com.chunjae.test04.entity.User;

import java.util.List;

public interface UserService {

    public List<User> userList() throws Exception;
    public User userGet(String eName) throws Exception;
    public Boolean userGetByEName(User user) throws Exception;
    public Boolean userGetByEmail(User user) throws Exception;
    public User userFindById(User user) throws Exception;
    public User userFindByPw(User user) throws Exception;
    public int userInsert(User user) throws Exception;
    public void userActWithdrawUpdate(String eName) throws Exception;
    public void userActDormantUpdate(String eName) throws Exception;
    public void userActJoinUpdate(String eName) throws Exception;
    public int userInfoUpdate(User user) throws Exception;
    public void userPwUpdate(User user) throws Exception;
    public void userPointUpdate(User user) throws Exception;
    public void userLevUpdate(User user) throws Exception;
    public int userDelete(String eName) throws Exception;

}