package com.midterm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.repositories.DrinkRepository;

@Service
public class DrinkService {
    
    @Autowired
    private DrinkRepository repository;

    public DrinkRepository getRepository() {
        return repository;
    }

    public void setRepository(DrinkRepository repository) {
        this.repository = repository;
    }

}
