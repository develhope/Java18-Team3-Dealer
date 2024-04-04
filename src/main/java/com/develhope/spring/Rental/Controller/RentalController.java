package com.develhope.spring.Rental.Controller;

import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Rental.RentalService.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/rental")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/getNewRental")
    public Rental createRental(@RequestBody Rental rental){
        return rentalService.newRental(rental);
    }

    @DeleteMapping("/deleteRental/{rentalId}")
    public void deleteRental(@PathVariable Long rentalId){
        rentalService.deleteRental(rentalId);
    }

    @PutMapping("/updateRental/{rentalId}")
    public Rental updateRental(@PathVariable Long rentalId, @RequestBody Rental rental){
        return rentalService.updateRental(rentalId, rental);
    }

    @PutMapping("/modifyRental/{rentalId}")
    public Rental modifyRental(@PathVariable Long rentalId, @RequestBody Rental rental){
        return rentalService.modifyRental(rentalId, rental);
    }

    @GetMapping("/getList")
    public List<Rental> getListRental (){
        return rentalService.getListRental();
    }
}
