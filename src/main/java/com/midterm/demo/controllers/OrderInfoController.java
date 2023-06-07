package com.midterm.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.midterm.demo.models.OrderInfo;
import com.midterm.demo.service.OrderInfoService;
import com.midterm.demo.service.OrderService;
import com.midterm.demo.utils.OrderWrapper;

@Controller
public class OrderInfoController {

    @Autowired
    OrderInfoService service;

    @Autowired
    OrderService orderservice;

    @PostMapping("/giccafe/ordering")
    public String ordering_info(@RequestBody OrderWrapper orderWrapper){
        // System.out.println(orderservice.getLastestOrder().getId());
        int lastest_order_id = orderservice.getLastestOrder().getId();
        List<OrderInfo> orders = orderWrapper.getOrders();
        orders.forEach((data) -> {
            data.setOrder_id(lastest_order_id);
            service.saveOrderInfo(data);
        });
        return "redirect:/giccafe/order";
    }

    @GetMapping("/get_order_info_by_join_table")
    public String orderInfos(){
        return "";
    }

}
