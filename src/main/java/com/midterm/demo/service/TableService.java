package com.midterm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.midterm.demo.models.Tables;
import com.midterm.demo.repositories.TableRepository;

@Service
public class TableService {
    
    @Autowired
    private TableRepository repository;

    public List<Tables> getTables(){
        return repository.findAll();
    }

    @Transactional
    public int setStatusTableById(int id, int status){
        return repository.setStatusTableById(id, status);
    }

    @Transactional
    public int setStatusTableByIdOrder(int id, int status){
        return repository.setStatusTableByIdOrder(id, status);
    }

}
