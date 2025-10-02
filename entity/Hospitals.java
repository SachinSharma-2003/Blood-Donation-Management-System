package com.example.Blood_Donation_Management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hospitals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospital_name;
    private String city;
    private String phone_number;
    private String full_address;
    private String official_email_address;
    private String password;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHospital_name() { return hospital_name; }
    public void setHospital_name(String hospital_name) { this.hospital_name = hospital_name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPhone_number() { return phone_number; }
    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public String getFull_address() { return full_address; }
    public void setFull_address(String full_address) { this.full_address = full_address; }

    public String getOfficial_email_address() { return official_email_address; }
    public void setOfficial_email_address(String official_email_address) { this.official_email_address = official_email_address; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
