package com.midterm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.repositories.DrinkRepository;

@Service
public class DrinkService {
    
    @Autowired
    DrinkRepository repository;

}
