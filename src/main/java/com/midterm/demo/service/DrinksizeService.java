package com.midterm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.midterm.demo.repositories.DrinksizeRepository;

@Service
public class DrinksizeService {
    
    @Autowired
    DrinksizeRepository repository;

}
