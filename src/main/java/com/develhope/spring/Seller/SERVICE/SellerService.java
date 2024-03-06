package com.develhope.spring.Seller.SERVICE;

import com.develhope.spring.Seller.REPOSITORY.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
}
