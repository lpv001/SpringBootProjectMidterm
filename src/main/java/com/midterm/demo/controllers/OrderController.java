package com.midterm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.midterm.demo.models.Order;
import com.midterm.demo.service.OrderService;
import com.midterm.demo.utils.OrderWrapper;

@Controller
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping("/giccafe/ordering")
    public String ordering_info(@RequestBody OrderWrapper orderWrapper){
        List<Order> orders = orderWrapper.getOrders();
        orders.forEach((data) -> {
            service.saveOrder(data);
        });
        return "redirect:/giccafe/order";
    }

}
