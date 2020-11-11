package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getRequestMapping(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/sharif")
    public String getRequestMapping2(){
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/sharif")
    public String getRequestMapping3(){
        return "home";
    }

//    @GetMapping("/spring")
//    public String getMappingEx(){
//        return "home";
//    }

    @PostMapping("/spring")
    public String getMappingEx2(){
        return "home";
    }

    @GetMapping("/home/{name}")
    public String pathVariableEx(@PathVariable("name") String name){
        System.out.println("home name is: " + name);
        return "home";
    }

    @GetMapping("/home/{name}/{email}")
    public String pathVariableEx2(@PathVariable("name") String name,@PathVariable("email") String email){
        System.out.println("home name is: " + name);
        System.out.println("home email is: " + email);
        return "home";
    }

//    http://localhost:8080/home/course1?course=spring
    @GetMapping("home/course1")
    public String requestParamEx(@RequestParam("course") String course){
        System.out.println("course1 name is :" + course);
        return "home";
    }

    @GetMapping("home/course2")
    public String requestParam2(@RequestParam(value = "course2",required = false,defaultValue = "Cybertek") String name){
        System.out.println("course2 name is: " + name);
        return "home";
    }






}