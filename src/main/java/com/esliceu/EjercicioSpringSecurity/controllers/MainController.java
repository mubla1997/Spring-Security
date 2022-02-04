package com.esliceu.EjercicioSpringSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

}
