package com.develhope.spring.Purchase.Service;

import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Purchase.Repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;
}
