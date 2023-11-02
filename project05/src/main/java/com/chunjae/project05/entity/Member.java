package com.chunjae.project05.entity;

import lombok.Data;

@Data
public class Member {

    private Integer id;
    private String eName;
    private String ePassword;
    private String userName;
    private String email;
    private String address;
    private String tel;
    private int point;
    private String regDate;
    private String lev;
    private String act;

}