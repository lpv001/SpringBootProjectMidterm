package com.midterm.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import com.midterm.demo.repositories.DrinkRepository;
import com.midterm.demo.service.DrinkService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midterm.demo.models.Drink;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.ui.Model;


@Controller
public class DrinkControllers {

    @Autowired
    private DrinkService service;

    // @GetMapping("/drinklist")
    // public String drink(Model model){
    //     model.addAttribute("drinklists", service.getDrink());
    //     return "listdrink";
    // }

    @PostMapping("/create_new_drink")
    public String create_new_drink(@ModelAttribute Drink form, RedirectAttributes redirectAttributes){

        // if ( file.isEmpty() ){
        //     redirectAttributes.addFlashAttribute("errorMessage", "Image not found");
        //     return "redirect:/gicadmin/create_drink";
        // }
        // String fileLocation = new File("demo//src//main//resource//static//images//drink_image").getAbsolutePath();
        // System.out.println(form.getDrinkname());
        // Path path = Paths.get("", file.getOriginalFilename());

        System.out.println();

        return "redirect:/gicadmin/create_drink";
    }
     
}

