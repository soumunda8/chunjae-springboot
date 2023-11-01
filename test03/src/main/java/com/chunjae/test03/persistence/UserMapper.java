package com.chunjae.test03.persistence;

import com.chunjae.test03.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> userList() throws Exception;
    User userGetByEName(String eName) throws Exception;
    User userGetByEmail(String email) throws Exception;
    User userFindById(User user) throws Exception;
    User userFindByPw(User user) throws Exception;
    int userInsert(User user) throws Exception;
    void userActWithdrawUpdate(String eName) throws Exception;
    void userActDormantUpdate(String eName) throws Exception;
    void userActJoinUpdate(String eName) throws Exception;
    int userInfoUpdate(User user) throws Exception;
    void userPwUpdate(User user) throws Exception;
    void userPointUpdate(User user) throws Exception;
    void userLevUpdate(User user) throws Exception;
    int userDelete(String eName) throws Exception;

}