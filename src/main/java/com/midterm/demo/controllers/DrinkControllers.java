package com.midterm.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import com.midterm.demo.repositories.DrinkRepository;
import com.midterm.demo.service.DrinkService;


import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/create_drink")
    public Object create_drink(){
        return new ModelAndView("create_drink");
    }

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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/drink")
    public Object admin_drink(){
        ModelAndView modelAndView = new ModelAndView("admindrink");
        modelAndView.addObject("drinks", service.getDrink());
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/edit_drink/{id}")
    public Object edit_drink(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("edit_drink");
        modelAndView.addObject("drink", service.findDrinkById(id).get());
        return modelAndView;
    }
     
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/delete_drink/{id}")
    public String delete_drink(@PathVariable Long id){
        service.deleteDrinkById(id);
        return "redirect:/gicadmin/drink";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/edit_drink_by_id/{id}")
    public String edit_drink_by_id(@ModelAttribute Drink form, @RequestParam(value = "image") MultipartFile image, RedirectAttributes redirectAttributes){
        
        
        if ( image.getOriginalFilename().equals("") ){
            service.setUpdateTableById(form.getCategory(), form.getCode(), form.getDrinkname(), form.getImage_path(), form.getNote(), form.getId());
        }else{
            service.setUpdateTableById(form.getCategory(), form.getCode(), form.getDrinkname(), image.getOriginalFilename(), form.getNote(), form.getId());
            try {
                File saveFile = new ClassPathResource("static/drinkimage").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + image.getOriginalFilename());
                Files.write(path, image.getBytes());
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        redirectAttributes.addFlashAttribute("successMessage", "Edit drink successfully!");

        return "redirect:/gicadmin/drink";
    }

    @GetMapping(path = "/giccafe/order")
    public Object order(){
        ModelAndView modelAndView = new ModelAndView("Order");
        modelAndView.addObject("hotdrinks", service.getDrinkByCategory("hot"));
        modelAndView.addObject("cooldrinks", service.getDrinkByCategory("cool"));
        modelAndView.addObject("frappedrinks", service.getDrinkByCategory("frappe"));
        modelAndView.addObject("foods", service.getDrinkByCategory("food"));
        return modelAndView;
    }

}


