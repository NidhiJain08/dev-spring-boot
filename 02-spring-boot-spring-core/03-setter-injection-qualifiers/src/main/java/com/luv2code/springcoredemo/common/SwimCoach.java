package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{
    @Override
    public String getDailyWorkout(){
        return  "practice swimming faster...";
    }
}
