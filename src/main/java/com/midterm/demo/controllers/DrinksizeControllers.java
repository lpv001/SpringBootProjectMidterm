package com.midterm.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.repositories.DrinksizeRepository;
import com.midterm.demo.service.DrinksizeService;

@RestController
public class DrinksizeControllers {
    @Autowired
    DrinksizeService service;

    // @GetMapping (path="/listdrinksize")
    // public Object Drinksize(){
    //     return new ModelAndView("listdrinksize");
    // }
    
    
}