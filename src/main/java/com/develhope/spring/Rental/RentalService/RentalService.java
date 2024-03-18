package com.develhope.spring.Rental.RentalService;

import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Rental.RentalRepository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
}
