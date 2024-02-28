package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ChocolateService chocolateService;

    @Autowired
    EstateService estateService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Estate estate1 = new Estate("chocy1", "Germany");
        Estate estate2 = new Estate("chocy2", "Switzerland");
        Estate estate3 = new Estate("chochy3", "England");

        Chocolate chocolate1 = new Chocolate("Snickers", 60, estate1);
        Chocolate chocolate2 = new Chocolate("Galaxy", 70, estate2);
        Chocolate chocolate3 = new Chocolate("Kinder Bueno", 80, estate3);
        Chocolate chocolate4 = new Chocolate("Malteasers", 40, estate1);

        estateService.addNewEstate(estate1);
        estateService.addNewEstate(estate2);
        estateService.addNewEstate(estate3);

        chocolateService.addNewChocolate(chocolate1);
        chocolateService.addNewChocolate(chocolate2);
        chocolateService.addNewChocolate(chocolate3);
        chocolateService.addNewChocolate(chocolate4);

    }



}
