package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model){

        model.addAttribute("name","Cybertek");
        model.addAttribute("course","MVC");

        String subject = "Collections";
        model.addAttribute("subject",subject);

//        String id = UUID.randomUUID().toString();
        int studentId = new Random().nextInt(1000);
        model.addAttribute("id",studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        model.addAttribute("numbers",numbers);

        //print your birthday
        LocalDate birthday = LocalDate.of(1988, Month.MAY,3);
        model.addAttribute("birthday",birthday);

        return "student/welcome";
    }
}
