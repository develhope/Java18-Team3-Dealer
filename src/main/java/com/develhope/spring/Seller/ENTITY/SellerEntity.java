package com.develhope.spring.User.UserEntity;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private TypeUser typeUser;

    public User(Long id, String firstName, String lastName, String telephoneNumber, String email, String password, TypeUser typeUser) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", typeUser=" + typeUser +
                '}';
    }
}
