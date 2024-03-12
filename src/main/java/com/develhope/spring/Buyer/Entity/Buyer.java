package com.develhope.spring.Buyer.Entity;

import jakarta.persistence.*;
@Table
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyer_id;
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

    public Long getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Long buyer_id) {
        this.buyer_id = buyer_id;
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

    public Buyer(Long buyer_id, String firstName, String lastName, String telephoneNumber, String email, String password) {
        this.buyer_id = buyer_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.password = password;
    }

    public Buyer() {
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "buyer_id=" + buyer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
