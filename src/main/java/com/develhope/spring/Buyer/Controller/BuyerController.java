package com.develhope.spring.Buyer.Controller;

import com.develhope.spring.Buyer.Service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;
}
