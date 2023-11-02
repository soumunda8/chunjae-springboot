package com.chunjae.project05.biz;

import com.chunjae.project05.entity.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface MemberService {

    public List<Member> getUserList();
    public Member getUser(String eName);
    public int getWithdraw(Integer id);
    public int getActivate(String eName);
    public int getDormant(String eName);
    public Member getByEmail(String email);
    public Member getByName(String eName);
    public Member findById(String email, String tel);
    public Member findByPw(String email, String tel, String eName);
    public int userJoin(Member member);
    public int updateUser(Member member);
    public int updateLevel(String eName, String lev);
    public int removeUser(String eName);
    public Member getUserById(Long id);
    public PasswordEncoder passwordEncoder();

}