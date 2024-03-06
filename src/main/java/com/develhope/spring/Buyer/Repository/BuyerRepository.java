package com.develhope.spring.Buyer.Repository;

import com.develhope.spring.Buyer.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
