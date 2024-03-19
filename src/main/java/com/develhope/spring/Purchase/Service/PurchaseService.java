package com.develhope.spring.Purchase.Service;


import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Purchase.Repository.PurchaseRepository;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public List<Purchase> purchaseList(Purchase purchase) {
        return purchaseRepository.findAll();
    }

    public Purchase purchasableOrder(Purchase purchase) {
        if (purchase.getVehicle() != null && purchase.getVehicle().getVehicleStatus() == VehicleStatus.PURCHASABLE) {
            purchaseRepository.save(purchase);
            return purchase;
        }
        return null;
    }

    public void deletePurchase(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Long purchaseId, Purchase purchase) {
        Purchase savePurchase = purchaseRepository.findById(purchaseId).orElse(null);
        if (savePurchase != null) {
            savePurchase.setPaid(purchase.getPaid());
            savePurchase.setAdvance(purchase.getAdvance());
            savePurchase.setPurchaseStatus(purchase.getPurchaseStatus());
            return purchaseRepository.save(savePurchase);
        }
        return null;
    }

    public Purchase setPurchaseStatus(Long purchaseId, Boolean isPaid) {
        Optional<Purchase> student = purchaseRepository.findById(purchaseId);
        if (student.isPresent()) {
            student.get().setPaid(isPaid);
            return purchaseRepository.saveAndFlush(student.get());
        } else return null;
    }
}
