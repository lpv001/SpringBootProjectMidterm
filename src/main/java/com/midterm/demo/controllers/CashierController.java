package com.midterm.demo.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Provider.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.midterm.demo.models.Cashier;
import com.midterm.demo.repositories.CashierRepository;
import com.midterm.demo.service.CashierService;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;



@Controller
public class CashierController{

    private CashierRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private CashierService service;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/create_cashier")
    public Object create_cashier(){
        return new ModelAndView("create_cashier");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/view_cashier")
    public Object view_cashier(){
        ModelAndView modelAndView = new ModelAndView("cashierinter");
        modelAndView.addObject("cashiers", service.getCashiers());
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/delete_cashier/{id}")
    public String delete_drink(@PathVariable Long id){
        service.deleteCashier(id);
        return "redirect:/gicadmin/view_cashier";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create_cashier")
    public String create_cashier(@ModelAttribute Cashier form, @RequestParam(value = "image") MultipartFile image, RedirectAttributes redirectAttributes) throws Exception {
        
        Cashier cashier = new Cashier();
        cashier.setFirstname(form.getFirstname());
        cashier.setLastname(form.getLastname());
        cashier.setDob(form.getDob());
        cashier.setSex(form.getSex());
        cashier.setUsername(form.getUsername());
        cashier.setType(form.getType());
        cashier.setPassword(form.getPassword());
        cashier.setImage_path(image.getOriginalFilename());

        if (
            !image.getOriginalFilename().equals("")
        ){
            Cashier uploading = service.saveCashier(cashier);

            if ( uploading != null ){
                try {
                    File saveFile = new ClassPathResource("static/cashierimage").getFile();
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + image.getOriginalFilename());
                    Files.write(path, image.getBytes());
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }

            redirectAttributes.addFlashAttribute("successMessage", "Create cashier successfully!");

        }else{
            redirectAttributes.addFlashAttribute("errorMessage", "Create cashier failed!");
        }

        return "redirect:/gicadmin/create_cashier";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/get_cashiers")
    public List<Cashier> get_cashiers(){
        return service.getCashiers();
    }


    @GetMapping("/gicadmin/updateCashier/{id}")
    public ModelAndView updateCashier(@PathVariable(value = "id") Long id) {
        Cashier cashier = service.getCashierById(id);
        return new ModelAndView("updateCashier", "cashier", cashier);
    }

    @PostMapping("/saveCashier")
    public String saveCashier(@ModelAttribute("cashiers") Cashier form,
        @RequestParam(value = "image") MultipartFile image, RedirectAttributes redirectAttributes) {

            if ( image.getOriginalFilename().equals("") ){
                service.setUpdateCashierById(form.getFirstname(), form.getLastname(), form.getUsername(), form.getImage_path(), form.getSex(), form.getId(), form.getDob(), form.getPassword(), form.getType());
            }else{
                service.setUpdateCashierById(form.getFirstname(), form.getLastname(), form.getUsername(), image.getOriginalFilename(), form.getSex(), form.getId(), form.getDob(), form.getPassword(), form.getType());
                try {
                    File saveFile = new ClassPathResource("static/cashierimage").getFile();
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + image.getOriginalFilename());
                    Files.write(path, image.getBytes());
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
    
            redirectAttributes.addFlashAttribute("successMessage", "Edit drink successfully!");
    
            return "redirect:/gicadmin/view_cashier";

    }

}