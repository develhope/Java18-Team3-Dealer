package com.develhope.spring.Buyer.Service;

import com.develhope.spring.Buyer.Repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {
    @Autowired
    BuyerRepository buyerRepository;
}
