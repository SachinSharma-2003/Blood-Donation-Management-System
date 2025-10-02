package com.example.Blood_Donation_Management.Repo;

import com.example.Blood_Donation_Management.entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepo extends JpaRepository<BloodRequest, Long> {
}

