package com.floatcloud.oamanage.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Float
 * 登录控制器
 */
@Controller
public class LoginController {

    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        HttpSession httpSession){
        // TODO 登录验证

        return "redirect:/index.html";
    }


}
