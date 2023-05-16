package com.midterm.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import com.midterm.demo.repositories.DrinkRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.midterm.demo.models.Drink;

import java.util.List;
import java.util.Optional;


@RestController
public class DrinkControllers {
    @Autowired
    private DrinkRepository drinkRepository;
    // @GetMapping(path = "/")

    // @GetMapping("/Drink")
    // public ModelAndView 

    // public List<Drink> getDrinks(@RequestParam("search")Optional<String> searchParam){
    //     return searchParam.map( param->drinkRepository.getContainingDrinks(param) )
    //     .orElse(drinkRepository.findAll());
    // }
//     @GetMapping("Drink/{drinkID}" )
//     public ResponseEntity<String> readDrink(@PathVariable("drinkID")Long id){
//         return ResponseEntity.of(drinkRepository.findById(id).map(Drink::getNameDrink));

//     }
//     @PostMapping("/Drink")
//     public Drink addDrink(@RequestBody String nameDrink){
//         Drink drink=new Drink();
//         drink.setNameDrink(nameDrink);
//         return drinkRepository.save(drink);
//     }
//     @RequestMapping(value = "/Drink/{drinkID}",method = RequestMethod.DELETE)
//     public void deleteDrink(@PathVariable(value="drinkID")Long id)
//     {
//         drinkRepository.deleteById(id);
//     }
}
