package com.develhope.spring.Buyer.Repository;

import com.develhope.spring.Buyer.DTO.BuyerDTO;
import com.develhope.spring.Buyer.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    @Query("SELECT b FROM Buyer b WHERE b.id = :buyerId")
    static Optional<Buyer> findById(@Param("buyerId") Long buyerId);
}
