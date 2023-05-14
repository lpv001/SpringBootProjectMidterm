package com.midterm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.repositories.CashierRepository;
import com.midterm.demo.models.Cashier;

@Service
public class CashierService {
    
    @Autowired
    private CashierRepository repository;

    public Cashier saveCashier(Cashier cashier){
        return repository.save(cashier);
    }

    public List<Cashier> getCashiers(){
        return repository.findAll();
    }

}
