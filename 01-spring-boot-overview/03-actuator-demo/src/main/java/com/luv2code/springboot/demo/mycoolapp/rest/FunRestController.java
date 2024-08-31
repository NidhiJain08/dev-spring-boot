package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
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
