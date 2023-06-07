package com.midterm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.midterm.demo.models.Order;
import com.midterm.demo.service.OrderService;
import com.midterm.demo.utils.OrderRecordWrapper;

@Controller
public class OrderController {
    
    @Autowired
    OrderService service;

    @PostMapping("/giccafe/order_record")
    public String ordering_record(@RequestBody OrderRecordWrapper orderRecordWrapper){
        List<Order> order = orderRecordWrapper.getOrder();

        order.forEach((data) -> {
            service.saveOrder(data);
        });
        
        return "redirect:/giccafe/order";
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/history")
    public String order(Model model){
        model.addAttribute("orders", service.getLatestOrder());
        return "history";
        
    }

}
