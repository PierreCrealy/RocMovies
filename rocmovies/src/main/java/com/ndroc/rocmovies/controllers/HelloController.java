package com.ndroc.rocmovies.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.welcomeMessage}")
    private String welcomeMessage;
    
    @GetMapping("/hello")
    public String sayHello(){
        
        return welcomeMessage;
    }

}
