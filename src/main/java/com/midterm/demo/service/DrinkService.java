package com.midterm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.models.Drink;
import java.util.List;
import com.midterm.demo.repositories.DrinkRepository;

@Service
public class DrinkService {
    
    @Autowired
    private DrinkRepository repository;

    public Drink saveDrink(Drink drink)
    {
        return repository.save(drink);
    }
    public List<Drink> getDrink(){
        return repository.findAll();
    }
}
