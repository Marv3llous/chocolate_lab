package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/estates")
public class EstateController {

    @Autowired
    EstateService estateService;

    @PostMapping
    public ResponseEntity<Estate> saveEstate (@RequestBody Estate estate){
        Estate savedEstate = estateService.addNewEstate(estate);
        return new ResponseEntity<>(savedEstate,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estate> findEstateById(@PathVariable long id){
        Optional<Estate> estate = estateService.findEstateById(id);
        if(estate.isPresent()){
            return new ResponseEntity<>(estate.get(), HttpStatus.OK);
        } return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
