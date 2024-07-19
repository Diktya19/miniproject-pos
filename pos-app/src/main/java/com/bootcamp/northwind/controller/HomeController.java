package com.bootcamp.northwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping("/")
    private String index(){
        return "layouts/main";
    }

    @GetMapping("/home")
    private String home(){
        return "pages/home/index";
    }

    @GetMapping("/dashboard")
    public ModelAndView dashboard(){
        return new ModelAndView("pages/home/index");
    }
}