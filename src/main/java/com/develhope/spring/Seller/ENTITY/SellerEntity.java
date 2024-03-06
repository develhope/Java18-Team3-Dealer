package com.develhope.spring.Seller.ENTITY;

import jakarta.persistence.*;

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

    public SellerEntity(Long sellerId, String firstName, String lastName, String phoneNumber, String email, String password) {
        this.sellerId = sellerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
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

    @Override
    public String toString() {
        return "SellerEntity{" +
                "sellerId=" + sellerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
