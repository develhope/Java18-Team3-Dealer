package com.develhope.spring.User.Entity;

import com.develhope.spring.Order.Entity.Orders;
import com.develhope.spring.Purchase.Entity.Purchase;
import com.develhope.spring.Rental.Entity.Rental;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false, name = "Nome")
    private String firstName;
    @Column(nullable = false, name = "Cognome")
    private String lastName;
    @Column(nullable = false, name = "Numero di telefono")
    private String telephoneNumber;
    @Column(unique = true, name = "Indirizzo email")
    private String email;
    @Column(nullable = false, length = 10)
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany
    private List<Orders> ordersList;
    @OneToMany
    private List<Purchase> purchaseList;
    @OneToMany
    private List<Rental> rentalList;

    public Users(Long userId, String firstName, String lastName, String telephoneNumber, String email, String password, List<Orders> ordersList, List<Purchase> purchaseList, List<Rental> rentalList, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
        this.ordersList = ordersList;
        this.purchaseList = purchaseList;
        this.rentalList = rentalList;
    }

    public Users() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", ordersList=" + ordersList +
                ", purchaseList=" + purchaseList +
                ", rentalList=" + rentalList +
                '}';
    }
}
