package com.app.esms.controller;

import com.app.esms.entity.Login;
import com.app.esms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SwitchPagesController {

    @RequestMapping("/forgot_pass")
    public String forgotPasswordPage(Model model){
        model.addAttribute("login", new Login());
        return "forgot_password";
    }

    @RequestMapping("/register")
    public String registrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String displayLogin(Model model) {
        model.addAttribute("login", new Login());
        return "login";
    }
}
