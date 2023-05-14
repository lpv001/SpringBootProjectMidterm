package com.midterm.demo.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SE_ProjectController1 {
    
    @GetMapping(path = "/giccafe/task1")
    public String index(){
        return "<h1>Welcome to TP16 Task1 jjkjsdjlk</h1>";
    }

}
