package com.develhope.spring.Buyer.Controller;

import com.develhope.spring.Buyer.DTO.BuyerDTO;
import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Buyer.Service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @PostMapping("/createBuyer")
    public Buyer createBuyer(@RequestBody BuyerDTO buyerDTO){
        return buyerService.createBuyer(buyerDTO);
    }

    @DeleteMapping("/deleteBuyer/{buyerId}")
    public void deleteBuyer(@PathVariable Long buyerId){
        buyerService.deleteBuyerByID(buyerId);
    }

    @PutMapping("/updateBuyer/{buyerId}")
    public Buyer updateBuyer(@PathVariable Long buyerId, @RequestBody BuyerDTO buyerDTO){
        return buyerService.updateBuyer(buyerId, buyerDTO);
    }

}
