package com.midterm.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.models.Drinksize;
import com.midterm.demo.repositories.DrinksizeRepository;
import com.midterm.demo.service.DrinksizeService;

@RestController
public class DrinksizeControllers {
    @Autowired
    DrinksizeService service;

    @GetMapping (path="/listdrinksize")
    public List<Drinksize> listdDrinksizes(){
        return service.getDrinksize();
    }
}
