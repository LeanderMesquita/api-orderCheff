package com.llm.orderCheff.entity;

import com.llm.orderCheff.entity.enums.Role;
import com.llm.orderCheff.utils.Randomizer;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "tb_users")
@SoftDelete
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;

    @Column(unique = true, length = 7)
    private String registrationCode;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String password;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;


    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.registrationCode = Randomizer.generateRegistration();
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User () {}

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

}
