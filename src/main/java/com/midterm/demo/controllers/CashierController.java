package com.midterm.demo.controllers;

import java.security.Provider.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.models.Cashier;
import com.midterm.demo.service.CashierService;



@RestController
public class CashierController{
    
    @Autowired
    private CashierService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/create_cashier")
    public Object create_cashier(){
        return new ModelAndView("create_cashier");
    }

    @PostMapping("/create_cashier")
    public Cashier create_cashier(@RequestBody Cashier cashier) throws Exception{
        return service.saveCashier(cashier);
    }

    @GetMapping("/get_cashiers")
    public List<Cashier> get_cashiers(){
        return service.getCashiers();
    }

}