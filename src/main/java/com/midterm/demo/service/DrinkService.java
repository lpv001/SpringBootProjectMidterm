package com.midterm.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.midterm.demo.models.Drink;
import java.util.List;
import java.util.Optional;

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

    public Optional<Drink> findDrinkById(Long id){
        return repository.findById(id);
    }

    public String deleteDrinkById(Long id){
        repository.deleteById(id);
        return "drink has been deleted";
    }

    @Transactional
    public int setUpdateTableById(String category, String code, String drinkname, String image_path, String note, int id){
        return repository.setUpdateTableById(category, code, drinkname, image_path, note, id);
    }

    public List<Drink> getDrinkByCategory(String category){
        return repository.getDrinkByCategory(category);
    }

}
