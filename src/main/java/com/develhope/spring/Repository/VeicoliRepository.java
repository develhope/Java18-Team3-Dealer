package com.develhope.spring.Repository;

import com.develhope.spring.Entity.Veicol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoliRepository extends JpaRepository<Veicol, Long> {
}