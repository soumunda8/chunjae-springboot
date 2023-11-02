package com.chunjae.project05.persistence;

import com.chunjae.project05.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<Member> getUserList();
    Member getUser(String eName);
    int getWithdraw(Integer id);
    int getActivate(String eName);
    int getDormant(String eName);
    Member getByEmail(String email);
    Member getByName(String eName);
    Member findById(String email, String tel);
    Member findByPw(String email, String tel, String eName);
    int userJoin(Member member);
    int updateUser(Member member);
    int updateLevel(String eName, String lev);
    int removeUser(String eName);
    Member getUserById(Long id);

}