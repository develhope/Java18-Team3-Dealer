package com.develhope.spring.Purchase.Service;


import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Purchase.Repository.PurchaseRepository;
import com.develhope.spring.Purchase.dto.PurchaseDTO;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;


    public List<PurchaseDTO> purchaseList() {
        List<Purchase> purchaseList = purchaseRepository.findAll() ;
        List<PurchaseDTO> purchaseDTOList = new ArrayList<>();
        if (purchaseList.isEmpty()){
            throw new IllegalArgumentException("Purchase not found");
        } else{
            for(Purchase purchase : purchaseList){
                purchaseDTOList.add(convertToDTO(purchase));
            }
        }
        return purchaseDTOList;
    }

    public PurchaseDTO purchasableOrder(PurchaseDTO purchaseDTO) {
        Purchase purchaseDto = convertToEntity(purchaseDTO);
        if (purchaseDto.getVehicle() != null && purchaseDto.getVehicle().getVehicleStatus() == VehicleStatus.PURCHASABLE) {
            purchaseRepository.save(convertToEntity(purchaseDTO));
            return purchaseDTO;
        } else{
            throw new IllegalArgumentException("Vehicle status not found");
        }
    }

    public void deletePurchase(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public PurchaseDTO updatePurchase(Long purchaseId, PurchaseDTO upPurchaseDTO) {
        Purchase savePurchase = purchaseRepository.findById(purchaseId).orElse(null);
       if(savePurchase == null){
           throw new IllegalArgumentException("Purchase not found by ID : " + purchaseId);
       }
         Purchase savePurchaseDTO = convertToEntity(upPurchaseDTO);
       savePurchase.setPaid(savePurchaseDTO.getPaid());
       savePurchase.setAdvance(savePurchaseDTO.getAdvance());
       savePurchase.setPurchaseStatus(savePurchaseDTO.getPurchaseStatus());
       purchaseRepository.save(savePurchase);
       return upPurchaseDTO;
    }

    public Purchase setPurchaseStatus(Long purchaseId, Boolean isPaid) {
        Optional<Purchase> student = purchaseRepository.findById(purchaseId);
        if (student.isPresent()) {
            student.get().setPaid(isPaid);
            return purchaseRepository.saveAndFlush(student.get());
        } else{
            throw new IllegalArgumentException("Error");
        }
    }

    private Purchase convertToEntity(PurchaseDTO purchaseDTO) {
        Purchase purchase = new Purchase();
        purchase.setAdvance(purchaseDTO.getAdvance());
        purchase.setPaid(purchaseDTO.getPaid());
        purchase.setPurchaseStatus(purchaseDTO.getPurchaseStatus());
        purchase.setVehicle(purchaseDTO.getVehicle());
        purchase.setBuyer(purchaseDTO.getBuyer());
        return purchase;
    }

    private PurchaseDTO convertToDTO(Purchase purchase) {
        PurchaseDTO PurchaseDTO = new PurchaseDTO();
        PurchaseDTO.setAdvance(purchase.getAdvance());
        PurchaseDTO.setPaid(purchase.getPaid());
        PurchaseDTO.setPurchaseStatus(purchase.getPurchaseStatus());
        PurchaseDTO.setVehicle(purchase.getVehicle());
        PurchaseDTO.setBuyer(purchase.getBuyer());
        return PurchaseDTO;
    }
}
