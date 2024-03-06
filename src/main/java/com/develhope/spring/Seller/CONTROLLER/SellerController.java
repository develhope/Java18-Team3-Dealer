package com.develhope.spring.Seller.CONTROLLER;

import com.develhope.spring.Seller.SERVICE.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class SellerController {
    @Autowired
    SellerService sellerService;

}
