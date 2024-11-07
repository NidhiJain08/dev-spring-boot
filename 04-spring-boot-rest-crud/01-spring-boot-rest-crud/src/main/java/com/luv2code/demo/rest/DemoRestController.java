package com.luv2code.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test") //test is base path for all the endpoints within this controller
public class DemoRestController {
    //add code for the /hello endpoint

    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }
}
