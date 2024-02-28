package com.bnta.chocolate.controllers;


import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @PostMapping
    public ResponseEntity<Chocolate> saveChocolate(@RequestBody Chocolate chocolate){
        Chocolate saveChocolate = chocolateService.addNewChocolate(chocolate);
        return new ResponseEntity<>(saveChocolate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Chocolate>> getChocolate(
            @RequestParam Optional<Integer> percentage
    ){
        List<Chocolate> chocolates;
        if(percentage.isPresent()){
            chocolates = chocolateService.getChocolateWithCocoaGreaterThan(percentage.get());
            return new ResponseEntity<>(chocolates, HttpStatus.OK);
        }
        chocolates = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }




    @GetMapping("/{id}")
    public ResponseEntity<Chocolate> getChocolateById (@PathVariable long id){
       Optional<Chocolate> chocolate = chocolateService.findChocolateById(id);
       if(chocolate.isPresent()){
           return new ResponseEntity<>(chocolate.get(),HttpStatus.OK);
       }
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }







}
