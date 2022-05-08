package com.app.esms.controller;

import com.app.esms.entity.Login;
import com.app.esms.entity.Users;
import com.app.esms.service.EmailService;
import com.app.esms.service.UserService;
import com.app.esms.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ResetPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @RequestMapping("/reset-pass")
    public ModelAndView registrationPage(@ModelAttribute("login") Login login,
                                   BindingResult result, ModelMap model) throws IOException {
        String email = login.getEmail();
        Users user = userService.getUserByEmailId(email);
        ModelAndView modelAndView = new ModelAndView("redirect:/forgot_pass");;

        if(user == null){
            modelAndView.addObject("reset_pass_msg", "Email Id is Invalid!");
        }else{
            String name = user.getFirstName()+" "+user.getLastName();
            Boolean isEmailSent = emailService.sendEmail(user.getEmail(),name, Constant.PasswordResetEmailSubject,user.getPassword());
            if(isEmailSent){
                modelAndView.addObject("reset_pass_msg", "Password sent to registered Email!");
            }else{
                modelAndView.addObject("reset_pass_msg", "Error occurred!!");
            }
        }
        return modelAndView;
    }
}
