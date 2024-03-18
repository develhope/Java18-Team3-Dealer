package com.develhope.spring.Rental.RentalService;

import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Rental.RentalRepository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class RentalService {
        @Autowired
        private RentalRepository rentalRepository;

        public Rental newRental(Rental rental) {      //dalla traccia di VENDITORE ho creato un nuovo noleggio
            return rentalRepository.save(rental);
        }

        public void deleteRental(Long id) {
            rentalRepository.deleteById(id);
        }

        public Rental updateRental(Long rentalId, Rental rental) {
            Rental newRental = rentalRepository.findById(rentalId).orElse(null);
            if (newRental != null) {                                                    //MODIFICARE UN NOLEGGIO
                newRental.setStartDate(rental.getStartDate());
                newRental.setEndDate(rental.getEndDate());
                newRental.setDailyCost(rental.getDailyCost());
                newRental.setTotalCost(rental.getTotalCost());
                newRental.setPaidFlag(rental.isPaidFlag());
                newRental.setRentalStatus(rental.getRentalStatus());
                return rentalRepository.save(newRental);
            }
            return null;
        }
    }

