package com.midterm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.models.Drinksize;
import com.midterm.demo.repositories.DrinksizeRepository;
import java.util.List;


@Service
public class DrinksizeService {
    
    @Autowired
    private DrinksizeRepository repository;

    
    public Drinksize saveDrinksize(Drinksize drinksize){
        return repository.save(drinksize);
    }
    public List<Drinksize> getDrinksize(){
        return repository.findAll();
    }
    
    
}
