package com.develhope.spring.Seller.REPOSITORY;

import com.develhope.spring.Seller.ENTITY.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository <SellerEntity, Long> {
}
