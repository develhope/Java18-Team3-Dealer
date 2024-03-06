package com.develhope.spring.User.Entity;
import jakarta.persistence.*;
@Table
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
    @Column(nullable = false, name = "Nome")
    private String firstName;
    @Column(nullable = false, name = "Cognome")
    private String lastName;
    @Column(unique = true, name = "Indirizzo email", nullable = false)
    private String email;
    @Column(nullable = false, length = 10)
    private String password;

    public Admin(Long admin_id, String firstName, String lastName, String email, String password) {
        this.admin_id = admin_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Admin() {
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setId(Long admin_id) {

        this.admin_id = admin_id;
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
        return "Admin{" +
                "admin_id=" + admin_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
