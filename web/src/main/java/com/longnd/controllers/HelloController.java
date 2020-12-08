package com.longnd.controllers;

import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.json.YamlJsonParser;
import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
//        SessionFixationProtectionStrategy a =
        String content = "{\"id\":1,\"name\":\"ram\"}";

        return content;
    }
}