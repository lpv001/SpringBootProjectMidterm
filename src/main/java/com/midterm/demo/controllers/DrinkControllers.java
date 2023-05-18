package com.midterm.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import com.midterm.demo.repositories.DrinkRepository;
import com.midterm.demo.service.DrinkService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.models.Drink;

import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;


@Controller
public class DrinkControllers {

    @Autowired
    private DrinkService service;

    @GetMapping("/drinklist")
    public String drink(Model model){
        model.addAttribute("drinklists", service.getDrink());
        return "listdrink";

    }
     
}
