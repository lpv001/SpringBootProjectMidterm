package com.midterm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.models.Tables;
import com.midterm.demo.repositories.TableRepository;
import com.midterm.demo.service.TableService;

@Controller
public class TableController {
    
    @Autowired
    TableService service;

    // @GetMapping("/get_tables")
    // public List<Tables> get_tables(){
    //     return service.getTables();
    // }

    @PostMapping("/set_table_by_id/{id}/{status}")
    public String set_status_table_by_id(@PathVariable int id, @PathVariable int status){
        service.setStatusTableById(id, status);
        return "redirect:/giccafe/table";
    }

    @GetMapping(path = "/giccafe/table")
    public Object table(){
        ModelAndView modelAndView = new ModelAndView("table");
        modelAndView.addObject("tables", service.getTables());
        return modelAndView;
    }

}
