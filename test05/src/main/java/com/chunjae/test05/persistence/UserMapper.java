package com.chunjae.test05.persistence;

import com.chunjae.test05.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getUserList();
    User getUser(String eName);
    User getByEmail(String email);
    User getByName(String eName);
    User findById(String email, String tel);
    User findByPw(String email, String tel, String eName);
    User getUserById(Long id);
    int getWithdraw(Integer id);
    int getActivate(String eName);
    int getDormant(String eName);
    int userUpdateInfo(User user);
    int userUpdatePw(User user);
    int userUpdatePoint(User user);
    int userJoin(User user);
    int userLevUpdate(String eName, String lev);
    int removeUser(String eName);

}