package com.develhope.spring.Admin.Controller;

import com.develhope.spring.Admin.Service.AdminService;
import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Rental.Entity.Rental;
import com.develhope.spring.Seller.ENTITY.SellerEntity;
import com.develhope.spring.Vehicle.Entity.Vehicle;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;


    // Altri metodi per la gestione del sistema automobilistico

    @GetMapping("/sellers/{sellerId}/sales")
    public int getSellerSalesInPeriod(@PathVariable Long sellerId, @RequestParam Date startDate, @RequestParam Date endDate) {
        return adminService.getSellerSalesInPeriod(sellerId, startDate, endDate);
    }

    @GetMapping("/sellers/{sellerId}/revenue")
    public double getSellerRevenueInPeriod(@PathVariable Long sellerId, @RequestParam Date startDate, @RequestParam Date endDate) {
        return adminService.getSellerRevenueInPeriod(sellerId, startDate, endDate);
    }

    @GetMapping("/revenue")
    public double getSalonRevenueInPeriod(@RequestParam Date startDate, @RequestParam Date endDate) {
        return adminService.getSalonRevenueInPeriod(startDate, endDate);
    }

    @GetMapping("/best-selling-vehicle")
    public Vehicle getBestSellingVehicleInPeriod(@RequestParam Date startDate, @RequestParam Date endDate) {
        return adminService.getBestSellingVehicleInPeriod(startDate, endDate);
    }

    @GetMapping("/highest-value-vehicle")
    public Vehicle getHighestValueVehicleSoldUntilDate(@RequestParam Date date) {
        return adminService.getHighestValueVehicleSoldUntilDate(date);
    }

    @GetMapping("/most-searched-vehicle")
    public Vehicle getMostSearchedVehicle() {
        return adminService.getMostSearchedVehicle();
    }
}






