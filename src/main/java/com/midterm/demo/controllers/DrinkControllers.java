package com.midterm.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.midterm.demo.repositories.DrinkRepository;
import com.midterm.demo.service.DrinkService;


import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midterm.demo.models.Drink;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;


@Controller
public class DrinkControllers {

    @Autowired
    private DrinkService service;

    @Autowired
    private DrinkRepository repository;

    // @GetMapping("/drinklist")
    // public String drink(Model model){
    //     model.addAttribute("drinklists", service.getDrink());
    //     return "listdrink";
    // }

    @PostMapping("/create_new_drink")
    public String create_new_drink(@ModelAttribute Drink form, @RequestParam(value = "image") MultipartFile image, RedirectAttributes redirectAttributes){

        Drink drink = new Drink();
        drink.setImage_path(image.getOriginalFilename());
        drink.setCategory(form.getCategory());
        drink.setCode(form.getCode());
        drink.setNote(form.getNote());
        drink.setPrice(form.getPrice());
        drink.setDrinkname(form.getDrinkname());

        if (
            !image.getOriginalFilename().equals("") && !form.getCategory().equals("") && !form.getCode().equals("") && !form.getNote().equals("") && !form.getPrice().equals("") && !form.getDrinkname().equals("") 
        ){
            Drink uploading = repository.save(drink);

            if ( uploading != null ){
                try {
                    File saveFile = new ClassPathResource("static/drinkimage").getFile();
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + image.getOriginalFilename());
                    Files.write(path, image.getBytes());
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            redirectAttributes.addFlashAttribute("successMessage", "Create drink successfully!");

        }else{
            redirectAttributes.addFlashAttribute("errorMessage", "Create drink failed!");
        }

        return "redirect:/gicadmin/create_drink";
    }

     
}


