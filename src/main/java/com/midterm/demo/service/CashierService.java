package com.midterm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.midterm.demo.repositories.CashierRepository;
import com.midterm.demo.models.Cashier;

@Service
public class CashierService {
    
    @Autowired
    private CashierRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Cashier saveCashier(Cashier cashier) throws Exception{
        cashier.setPassword(passwordEncoder.encode(cashier.getPassword()));
        return repository.save(cashier);
    }

    public List<Cashier> getCashiers(){
        return repository.findAll();
    }

    // public Cashier getCashierByUsername(String username){
    //     return repository.findByUsername(username);
    // }

}
