package com.develhope.spring.Buyer.Controller;

import com.develhope.spring.Buyer.DTO.BuyerDTO;
import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Buyer.Service.BuyerService;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Purchase.Entity.Purchase;
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
    @GetMapping("/ordersList/{orderId}/{buyerId}")
    public List<Orders> ordersList(@PathVariable Long buyerId, @PathVariable Long orderId){
        return buyerService.getOrders(orderId, buyerId);
    }
    @GetMapping("/purchaseList/{purchaseId}/{buyerId}")
    public List<Purchase> purchaseList(@PathVariable Long purchaseId, @PathVariable Long buyerId){
        return buyerService.getPurchase(purchaseId, buyerId);
    }
    @DeleteMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable Long orderId){
        buyerService.deleteOrderById(orderId);
    }
    @PutMapping("/updateBuyer/{buyerId}")
    public Buyer updateBuyer(@PathVariable Long buyerId, @RequestBody Buyer buyer){
        return buyerService.updateBuyer(buyerId, buyer);
    }

}
