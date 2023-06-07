package com.midterm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.models.Order;
import com.midterm.demo.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public Order saveOrder(Order order){
        return repository.save(order);
    }

    public Order getLastestOrder(){
        return repository.getLastestOrder();
    }
    public List<Order> getLatestOrder(){
        return repository.findAll();
    }

}
