package com.develhope.spring.Vehicle.Repository;

import com.develhope.spring.Vehicle.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
@Query(value = "SELECT * FROM VEHICLE WHERE COLOR = ?1", nativeQuery = true)
    List<Vehicle> getAllVehicleByColor(String color);
}