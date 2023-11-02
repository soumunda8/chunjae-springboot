package com.chunjae.project05.biz;

import com.chunjae.project05.entity.Member;
import com.chunjae.project05.persistence.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<Member> getUserList() {
        return memberMapper.getUserList();
    }

    @Override
    public Member getUser(String eName) {
        return memberMapper.getUser(eName);
    }

    @Override
    public int getWithdraw(Integer id) {
        return memberMapper.getWithdraw(id);
    }

    @Override
    public int getActivate(String eName) {
        return memberMapper.getActivate(eName);
    }

    @Override
    public int getDormant(String eName) {
        return memberMapper.getDormant(eName);
    }

    @Override
    public Member getByEmail(String email) {
        return memberMapper.getByEmail(email);
    }

    @Override
    public Member getByName(String eName) {
        return memberMapper.getByName(eName);
    }

    @Override
    public Member findById(String email, String tel) {
        return memberMapper.findById(email, tel);
    }

    @Override
    public Member findByPw(String email, String tel, String eName) {
        return memberMapper.findByPw(email, tel, eName);
    }

    @Override
    public int userJoin(Member member) {
        return memberMapper.userJoin(member);
    }

    @Override
    public int updateUser(Member member) {
        return memberMapper.updateUser(member);
    }

    @Override
    public int updateLevel(String eName, String lev) {
        return memberMapper.updateLevel(eName, lev);
    }

    @Override
    public int removeUser(String eName) {
        return memberMapper.removeUser(eName);
    }

    @Override
    public Member getUserById(Long id) {
        return memberMapper.getUserById(id);
    }

    @Override
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

}