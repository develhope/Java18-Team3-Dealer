package com.develhope.spring.Seller.ENTITY;

import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Rental.Entity.Rental;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class SellerEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long sellerId;
        @Column(nullable = false, name = "Nome")
        private String firstName;
        @Column(nullable = false, name = "Cognome")
        private String lastName;
        @Column(nullable = false, name = "Numero di telefono")
        private String phoneNumber;
        @Column(unique = true, name = "Indirizzo email")
        private String email;
        @Column(nullable = false, length = 10)
        private String password;
        @OneToMany
        private List<Orders> ordersList;
        @OneToMany
        private List<Rental> rentalList;

    public SellerEntity(Long sellerId, String firstName, String lastName, String phoneNumber, String email, String password, List<Orders> ordersList, List<Rental> rentalList) {
        this.sellerId = sellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.ordersList = ordersList;
        this.rentalList = rentalList;
    }

    public SellerEntity() {
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    @Override
    public String toString() {
        return "SellerEntity{" +
                "sellerId=" + sellerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ordersList=" + ordersList +
                ", rentalList=" + rentalList +
                '}';
    }
}
