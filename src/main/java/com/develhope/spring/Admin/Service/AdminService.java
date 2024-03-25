package com.develhope.spring.Admin.Service;

import com.develhope.spring.Admin.Entity.Admin;
import com.develhope.spring.Admin.Repository.AdminRepository;
import com.develhope.spring.Buyer.Entity.Buyer;
import com.develhope.spring.Buyer.Repository.BuyerRepository;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Order.Repository.OrderRepository;
import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Purchase.Repository.PurchaseRepository;
import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Rental.RentalRepository.RentalRepository;
import com.develhope.spring.Seller.ENTITY.SellerEntity;
import com.develhope.spring.Seller.REPOSITORY.SellerRepository;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import com.develhope.spring.Vehicle.Entity.VehicleStatus;
import com.develhope.spring.Vehicle.Repository.VehicleRepository;
import jakarta.persistence.criteria.Order;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository userRepository;

    // Metodi per la gestione degli amministratori

    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin not found with id: " + id));
    }

    public Admin updateAdmin(Long id, Admin admin) {
        Admin existingAdmin = getAdminById(id);
        existingAdmin.setFirstName(admin.getFirstName());
        existingAdmin.setLastName(admin.getLastName());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setPassword(admin.getPassword());
        return adminRepository.save(existingAdmin);
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Altri metodi per la gestione del sistema automobilistico

    public int getSellerSalesInPeriod(Long sellerId, Date startDate, Date endDate) {
        List<Orders> sellerOrders = orderRepository.findBySellerIdAndOrderDateBetween(sellerId, startDate, endDate);
        List<Purchase> sellerPurchases = purchaseRepository.findBySellerIdAndPurchaseDateBetween(sellerId, startDate, endDate);

        int totalSales = 0;

        for (Orders order : sellerOrders) {
            totalSales += order.getVeicoloOrdinato().getPrezzo(); // Supponiamo che il prezzo del veicolo sia il valore dell'ordine
        }

        for (Purchase purchase : sellerPurchases) {
            totalSales += purchase.getVeicoloAcquistato().getPrezzo(); // Supponiamo che il prezzo del veicolo sia il valore dell'acquisto
        }

        return totalSales;
    }

    public double getSellerRevenueInPeriod(Long sellerId, Date startDate, Date endDate) {
        // Implementa la logica per calcolare il ricavo del venditore nel periodo specificato
        return 0.0; // Placeholder
    }

    public double getSalonRevenueInPeriod(Date startDate, Date endDate) {
        // Implementa la logica per calcolare il ricavo del salone nel periodo specificato
        return 0.0; // Placeholder
    }


    public Vehicle getBestSellingVehicleInPeriod(Date startDate, Date endDate) {
        // 1. Query the database to retrieve all orders within the specified period
        List<Orders> ordersWithinPeriod = orderRepository.findByOrderDateBetween(startDate, endDate);

        // 2. Group the orders by vehicle and count the number of orders for each vehicle
        Map<Vehicle, Long> vehicleOrderCount = ordersWithinPeriod.stream()
                .collect(Collectors.groupingBy(Orders::getVehicle, Collectors.counting()));

        // 3. Determine the vehicle with the highest number of orders
        if (!vehicleOrderCount.isEmpty()) {
            Vehicle bestSellingVehicle = vehicleOrderCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
            return bestSellingVehicle;
        }

        return null; // No orders found within the specified period
    }

    public Vehicle getHighestValueVehicleSoldUntilDate(Date date) {
        // 1. Query the database to retrieve all orders until the specified date
        List<Order> ordersUntilDate = orderRepository.findByOrderDateBefore(date);

        // 2. Group the orders by vehicle and sum the total value of orders for each vehicle
        Map<Vehicle, Double> vehicleTotalOrderValue = ordersUntilDate.stream()
                .collect(Collectors.groupingBy(Order::getVehicle, Collectors.summingDouble(Order::getOrderValue)));

        // 3. Determine the vehicle with the highest total order value
        if (!vehicleTotalOrderValue.isEmpty()) {
            Vehicle highestValueVehicle = vehicleTotalOrderValue.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
            return highestValueVehicle;
        }

        return null; // No orders found until the specified date
    }

    //GET MOST SEARCHED VEHICLE
}