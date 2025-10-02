package com.example.Blood_Donation_Management.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")  // ✅ use a safe table name, not "user"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")      // ✅ maps correctly to DB
    private String full_name;

    @Column(name = "account_type")
    private String account_type;

    @Column(unique = true)           // ✅ emails should be unique
    private String email;

    private String phone;
    private String city;

    @Column(name = "blood_group")
    private String blood_group;

    private String password;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFull_name() { return full_name; }
    public void setFull_name(String full_name) { this.full_name = full_name; }

    public String getAccount_type() { return account_type; }
    public void setAccount_type(String account_type) { this.account_type = account_type; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getBlood_group() { return blood_group; }
    public void setBlood_group(String blood_group) { this.blood_group = blood_group; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", account_type='" + account_type + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
