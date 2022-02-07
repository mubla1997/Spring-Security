package com.esliceu.EjercicioSpringSecurity.controllers;

import com.esliceu.EjercicioSpringSecurity.services.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    LoginServiceImpl loginService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String fullname,
                               @RequestParam(required = false)byte[] photo){
        loginService.newUser(username,password,fullname);
        return "login";}

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(){
        return "entry";
    }

    @GetMapping("/entry")
    public String entryGet(){
        return"entry";
    }



}
