package com.app.esms.controller;

import com.app.esms.entity.Login;
import com.app.esms.entity.Users;
import com.app.esms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("login") Login login,
                              BindingResult result, ModelMap model){
        Users user = userService.login(login);
        if (user == null){
            ModelAndView modelAndView = new ModelAndView("redirect:/login");
            modelAndView.addObject("login_msg", "Invalid Username/Password");
            return modelAndView;
        }else{
            System.out.println("Logged in successfully!");
            return new ModelAndView("operation_page");
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("user") Users user,
                              BindingResult result, ModelMap model){
        String addedUser = userService.addUser(user);

        if(addedUser == null){
            ModelAndView modelAndView =  new ModelAndView("/register");
            modelAndView.addObject("register_msg", "Email ID already exist!");
            return modelAndView;
        }else{
            ModelAndView modelAndView =  new ModelAndView("/login");
            modelAndView.addObject("register_msg","Registered Success!");
            model.addAttribute("login", new Login());
            return modelAndView;
        }

    }
}
