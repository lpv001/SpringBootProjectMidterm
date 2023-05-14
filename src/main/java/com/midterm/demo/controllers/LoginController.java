package com.midterm.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.models.Cashier;
import com.midterm.demo.service.CashierService;

@RestController
public class LoginController {

    @Autowired
    private CashierService cashierService;

    // @GetMapping("/cashier/login")
    // public Object index(){
    // ModelAndView view = new ModelAndView("html/login");
    // return view;
    // }

    @GetMapping(path = "/cashier/login")
    public Object login() {
        return new ModelAndView("login");
    }

}
