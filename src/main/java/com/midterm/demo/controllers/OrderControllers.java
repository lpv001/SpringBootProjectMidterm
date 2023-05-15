package com.midterm.demo.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OrderControllers {
    @GetMapping(path = "/giccafe/Order")
    public Object obj(){
     return new ModelAndView("Order");
    }
    
}
