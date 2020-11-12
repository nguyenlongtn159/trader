package com.longnd.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello war";
    }

    @RequestMapping("/")
    public String greeting(){
        return "index.html";
    }
}
