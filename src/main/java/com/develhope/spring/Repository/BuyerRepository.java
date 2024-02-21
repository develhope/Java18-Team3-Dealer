package com.develhope.spring.Repository;

import com.develhope.spring.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BuyerRepository extends JpaRepository<User, Long> {
}
