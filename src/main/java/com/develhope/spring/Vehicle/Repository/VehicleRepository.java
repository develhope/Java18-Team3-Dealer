package com.develhope.spring.Vehicle.Repository;

import com.develhope.spring.Vehicle.Entity.Veicolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Veicolo, Long> {
}