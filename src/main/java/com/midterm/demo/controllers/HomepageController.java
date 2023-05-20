package com.midterm.demo.controllers;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomepageController {

    @GetMapping(path = "/giccafe/homepage")
    public Object obj(){
        return new ModelAndView("homepage");
    }

    @GetMapping(path = "/giccafe/order")
    public Object order(){
     return new ModelAndView("Order");
    }
    @GetMapping(path = "/giccafe/calculator")
    public Object calculator(){
     return new ModelAndView("calculator");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/homepage")
    public Object admin_home(){
        return new ModelAndView("adminhomepage");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/create_drink")
    public Object create_drink(){
        return new ModelAndView("create_drink");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/gicadmin/drink")
    public Object admin_drink(){
        return new ModelAndView("admindrink");
    }

}
