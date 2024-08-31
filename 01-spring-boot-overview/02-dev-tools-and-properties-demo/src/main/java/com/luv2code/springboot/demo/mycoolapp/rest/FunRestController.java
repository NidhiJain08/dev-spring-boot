package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {


    //inject properties for coach,team
    @Value("${team.name}")
    private String teamName;

    @Value("${coach.name}")
    private String coachName;

    @GetMapping("/teamInfo")
    public String teamInfo(){
        return "Coach is " + coachName + ",for team " + teamName;
    }

    @GetMapping("/")
    public String sayHello(){
        return "Hello from Secure Meters!";
    }

    //expose new EP for workout, workout matlab junk food han

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Please do workout daily!";
    }

    //expose a new EP for fortune , EP matlab endpoint han

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day!!";
    }


}
