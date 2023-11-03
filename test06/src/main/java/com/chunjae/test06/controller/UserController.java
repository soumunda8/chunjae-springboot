package com.chunjae.test06.controller;

import com.chunjae.test06.biz.UserService;
import com.chunjae.test06.entity.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String home(Model model) {

        Human human = new Human();
        human.setName("임창균");
        human.setAge(20);
        model.addAttribute("human", human);

        List<Human> hList = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            Human h = new Human();
            h.setName("손현우" + i);
            h.setAge(20);
            hList.add(h);
        }
        model.addAttribute("hList", hList);

        model.addAttribute("attrName", "임의필드");

        return "index";
    }

    @GetMapping(value = "login")
    public ModelAndView getLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        return modelAndView;
    }

    @PostMapping(value = "login")
    public String loginPro(@RequestParam("loginId") String loginId, @RequestParam("password") String password) {



        return "redirect:/";
    }

    @GetMapping(value = "registation")
    public ModelAndView getJoinPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/join");
        return modelAndView;
    }


}