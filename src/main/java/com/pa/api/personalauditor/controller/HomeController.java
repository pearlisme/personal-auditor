package com.pa.api.personalauditor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello, Personal Auditor!";
    }
}
