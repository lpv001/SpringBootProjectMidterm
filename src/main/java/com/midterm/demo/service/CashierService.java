package com.midterm.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.midterm.demo.repositories.CashierRepository;

import jakarta.transaction.Transactional;

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

    public String deleteCashier(Long id){
        repository.deleteById(id);
        return "cashier has been deleted";
    };

    public Cashier getCashierById(Long id){
        return repository.getById(id);
    }

    @Transactional
    public String setUpdateCashierById(String firstname, String lastname, String username, String image_path, String sex, int id, String dob, String password, String type){
        repository.setUpdateCashierById(firstname, lastname, username, image_path, sex, id, dob, password, type);
        return "update successfully";
    }

    public Integer getLoginUserId(String username){
        return repository.getLoginUserId(username);
    }

    // public Cashier getCashierByUsername(String username){
    //     return repository.findByUsername(username);
    // }

}
