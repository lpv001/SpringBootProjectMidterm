package com.midterm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.repositories.OrderInfoRepository;
import com.midterm.demo.models.OrderInfo;

@Service
public class OrderInfoService {
    
    @Autowired
    private OrderInfoRepository repository;

    public OrderInfo saveOrderInfo(OrderInfo order){
        return repository.save(order);
    }

}
