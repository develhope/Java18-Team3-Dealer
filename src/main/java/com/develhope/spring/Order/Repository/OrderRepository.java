package com.develhope.spring.Order.Repository;

import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT * FROM VEHICLE WHERE order_Status = ?1", nativeQuery = true)
    List<Orders> getAllOrdersStatus (String orderStatus);
}
