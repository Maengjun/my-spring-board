package org.example.realproject.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.realproject.domain.User;
import org.example.realproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/signup")
    public String register() {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.signup(user);
        return "redirect:/login";
    }

}
