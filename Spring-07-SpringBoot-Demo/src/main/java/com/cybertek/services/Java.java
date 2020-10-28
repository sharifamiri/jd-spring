package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {


    @Override
    public int getTeachingHours() {
        return 20;
    }
}
