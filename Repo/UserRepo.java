package com.example.Blood_Donation_Management.Repo;

import com.example.Blood_Donation_Management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}