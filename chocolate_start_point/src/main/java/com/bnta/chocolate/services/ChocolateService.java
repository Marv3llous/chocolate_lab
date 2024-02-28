package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public Chocolate addNewChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public Optional <Chocolate> findChocolateById(long id){
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getChocolateWithCocoaGreaterThan(int percentage){
        return chocolateRepository.findByCocoaPercentageGreaterThanEqual(percentage);
    }

    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

}
