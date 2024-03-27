package com.develhope.spring.Purchase.Controller;
import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Purchase.Service.PurchaseService;
import com.develhope.spring.Purchase.dto.PurchaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
    @PostMapping("/createPurchase")
    public Purchase  create(@RequestBody Purchase purchase){
        return purchaseService.createPurchase(purchase);
    }
    @GetMapping("/allPurchase")
    public List<PurchaseDTO> allPurchase(){
        return purchaseService.purchaseList();
    }
    @PostMapping("/purchasableOrder")
    public PurchaseDTO purchasable(@RequestBody PurchaseDTO purchaseDTO){
        return purchaseService.purchasableOrder(purchaseDTO);
    }
    @DeleteMapping("/delete/{purchaseId}")
    public void deletePurchase(@PathVariable Long purchaseId){
        purchaseService.deletePurchase(purchaseId);
    }
    @PutMapping("/update/{purchaseId}")
    public PurchaseDTO upPurchase(@PathVariable Long id, @RequestBody PurchaseDTO purchaseDTO){
        return purchaseService.updatePurchase(id,purchaseDTO);
    }
    @PutMapping("/setStatus/{purchaseId}")
    public Purchase setStatus(@PathVariable Long id,@RequestParam Boolean isPaid){
        return purchaseService.setPurchaseStatus(id,isPaid);
    }
}
