package com.develhope.spring.Purchase.Controller;

import com.develhope.spring.Purchase.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    PurchaseService purchaseService;
}
