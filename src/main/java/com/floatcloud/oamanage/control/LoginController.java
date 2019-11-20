package com.floatcloud.oamanage.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.floatcloud.oamanage.common.constant.SysConstant;

/**
 * LoginController
 * 登录功能
 * @auther FloatCloud
 * @date 2019/11/19
 */
@Controller
public class LoginController {


    @Autowired
    private SysConstant sysConstant;

    @PostMapping(value = "/login")
    public String login(@RequestParam("userName")String userName,
                        @RequestParam("passWord")String passWord,
                        HttpSession session){
        // TODO 登录验证
        session.setAttribute(sysConstant.getSessionUserName(),userName);
        return "redirect:/index";
    }
}
