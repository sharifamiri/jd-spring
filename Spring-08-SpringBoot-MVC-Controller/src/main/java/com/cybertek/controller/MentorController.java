package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {

    @GetMapping("/mentor")
    public String showForm(){
        return "home";
    }
}
