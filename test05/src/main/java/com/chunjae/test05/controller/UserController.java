package com.chunjae.test05.controller;

import com.chunjae.test05.biz.UserService;
import com.chunjae.test05.entity.User;
import com.chunjae.test05.exception.NoSuchDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin("http://localhost:8086")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList.do")
    public String getUserList(Model model) {
        List<User> userList = userService.getUserList();
        if(userList.isEmpty()) {
            throw new NoSuchDataException("No Such List");
        }
        model.addAttribute("msg", "회원 목록을 로딩합니다.");
        model.addAttribute("userList", userList);
        return "/admin/list";
    }

}