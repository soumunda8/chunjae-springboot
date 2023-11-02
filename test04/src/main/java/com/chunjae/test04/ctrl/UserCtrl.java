package com.chunjae.test04.ctrl;

import com.chunjae.test04.biz.UserService;
import com.chunjae.test04.entity.User;
import com.chunjae.test04.exception.NoSuchDataException;
import com.chunjae.test04.util.EmailSocket;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

// springframework 5장
// get - select 가져올때
// post - insert 할때
// delete - delete 할때
// put - update 할때

// delete + put 사용시 application.properties에 추가

@Controller
public class UserCtrl {

    @Autowired
    private UserService userService;

    @GetMapping("/list.do")
    public String userList(Model model) throws Exception {
        List<User> userList = userService.userList();
        if(userList.isEmpty()) {
            throw new NoSuchDataException("No Such List");
        }
        model.addAttribute("userList", userList);
        return "/user/list";
    }

    @GetMapping("/get.do")
    public String userList(@RequestParam("name") String eName, Model model) throws Exception {
        User user = userService.userGet(eName);
        if(user == null) {
            throw new NoSuchDataException("No Such Data");
        }
        model.addAttribute("user", user);
        return "/user/get";
    }

    // 로그인
    @GetMapping("/login.do")
    public String login(HttpSession session) throws Exception {

         if(session.getAttribute("sid") != null) {
             return "redirect:/";
         }

        return "/user/login";
    }

    @PostMapping("/login.do")
    public String loginPro(@RequestParam("id") String id, @RequestParam("pw") String pw, RedirectAttributes rttr) throws Exception {

        User user = new User();
        user.setEPassword(pw);

        boolean pass = false;
        if(id.contains("@")) {
            System.out.println("이메일");
            user.setEmail(id);
            pass = userService.userGetByEmail(user);
        } else {
            System.out.println("아이디");
            user.setEName(id);
            pass = userService.userGetByEName(user);
        }

        if(pass) {
            return "redirect:/";
        } else {
            rttr.addAttribute("message", "fail");
            return "redirect:/user/login.do";
        }
    }

    @GetMapping("/logout.do")
    public String logout(HttpSession session) throws Exception {

        session.invalidate();

        return "redirect:/";
    }
    
    // 로그인 - 이메일
    @GetMapping("/loginByEmail.do")
    public String loginByEmail() throws Exception {
        return "/user/loginByEmail";
    }

    @PostMapping("/loginByEmail.do")
    public String loginByEmailPro(User user, RedirectAttributes rttr) throws Exception {
        boolean pass = userService.userGetByEmail(user);
        if(pass) {
            return "redirect:/";
        } else {
            rttr.addAttribute("message", "fail");
            return "redirect:/loginByEmail.do";
        }
    }

    // 로그인 - 아이디
    /*@GetMapping("/loginById.do")
    public String loginById() throws Exception {
        return "/user/loginById";
    }*/

    @PostMapping("/loginById.do")
    @ResponseBody
    public String loginByIdPro(User user, RedirectAttributes rttr) throws Exception {
        boolean pass = userService.userGetByEName(user);
        if(pass) {
            return "redirect:/";
        } else {
            rttr.addAttribute("message", "fail");
            return "redirect:/loginById.do";
        }
    }
    
    // 탈퇴
    @GetMapping("/withDraw.do")
    public String userWithDraw(@RequestParam("name") String eName) throws Exception {
        userService.userActWithdrawUpdate(eName);
        return "redirect:/";
    }
    
    // 계정 활성화
    @GetMapping("/activate.do")
    public String userActive(@RequestParam("name") String eName) throws Exception {
        userService.userActJoinUpdate(eName);
        return "redirect:/";
    }
    
    // 휴먼 처리
    @GetMapping("/Dormant.do")
    public String userDormant(@RequestParam("name") String eName) throws Exception {
        userService.userActDormantUpdate(eName);
        return "redirect:/";
    }
    
    // 아이디 찾기
    @PostMapping("/findId.do")
    public String userFindId(User user) throws Exception {
        User mem = userService.userFindById(user);
        return "/user/findId";
    }
    
    // 비밀번호 찾기
    @PostMapping("/findPw.do")
    public String userFindPw(User user) throws Exception {
        User mem = userService.userFindById(user);
        sendMail(mem);
        return "/user/findPw";
    }

    public void sendMail(User user) {

        EmailSocket dm = new EmailSocket();
        dm.sendMail(user);

    }
    
    // 회원가입
    @GetMapping("/join")
    public String userJoin() throws Exception {
        return "login";
    }

    @PostMapping("/join")
    @ResponseBody
    public int userJoinPro(User user) throws Exception {
        int cnt = userService.userInsert(user);
        if(cnt == 0){
            throw new NoSuchDataException("No Insert Data");
        }
        //return userService.userGet(user.getEName());
        return cnt;
    }
    
    // 회원 정보 수정
    @GetMapping("/editInfo")
    public String userInfoUpdate() throws Exception {
        return "/user/myPage";
    }

    @PostMapping("/editInfo")
    public String userInfoUpdatePro(User user) throws Exception {
        int cnt = userService.userInfoUpdate(user);
        if(cnt == 0){
            throw new NoSuchDataException("No Delete Data");
        }
        return "redirect:/";
    }

    @GetMapping("/editPw")
    public String userPwUpdate() throws Exception {
        return "/user/myPagePw";
    }

    @PutMapping("/editPw")
    @ResponseBody
    public User userPwUpdatePro(@RequestParam("pw") String ePassword, @RequestParam("id") String eName) throws Exception {
        User user = new User();
        user.setEPassword(ePassword);
        user.setEName(eName);
        userService.userPwUpdate(user);
        return userService.userGet(eName);
    }

    @PostMapping("/editPoint")
    public String userPointUpdatePro(User user) throws Exception {
        userService.userPointUpdate(user);
        return "redirect:/";
    }
    
    // 회원 등급 변경
    @GetMapping("/editLevel")
    public String userLevelUpdate() throws Exception {
        return "/admin/updateLevel";
    }

    @PostMapping("/editLevel")
    public String userLevelUpdatePro(User user) throws Exception {
        userService.userLevUpdate(user);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public Boolean userDeletePro(@RequestParam("id") String eName) throws Exception {
        int cnt = userService.userDelete(eName);
        if(cnt == 0){
            throw new NoSuchDataException("No Delete Data");
        }
        return true;
    }

}