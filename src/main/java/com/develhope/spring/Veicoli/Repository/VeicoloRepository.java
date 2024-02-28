package com.develhope.spring.Veicoli.Repository;

import com.develhope.spring.Veicoli.Entity.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeicoloRepository extends JpaRepository<Veicolo, Long> {
}