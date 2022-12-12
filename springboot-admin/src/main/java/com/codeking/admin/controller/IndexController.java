package com.codeking.admin.controller;

import com.codeking.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author : codeking
 * @create : 2022/12/12 16:50
 */

@Controller
public class IndexController {
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    // 登录请求
    @PostMapping("/login")
    public String loginRequest(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:mian";
        } else {
            model.addAttribute("msg", "账号或者密码错误··");
            return "login";
        }
    }

    @GetMapping(value = {"/mian", "index.html"})
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            //System.out.println(loginUser.getClass());
            return "index";
        } else {
            model.addAttribute("msg", "请重新登录！");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("loginUser");
        model.addAttribute("msg", "请重新登录！");
        return "login";
    }
}
