    package com.chunjae.test06.entity;

import lombok.Data;

@Data
public class User {

    private int id;
    private int active;
    private String loginId;
    private String userName;
    private String password;

}
