package com.example.Blood_Donation_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Blood_Donation_Management.entity.Donor;

@Repository
public interface DonorRepo extends JpaRepository<Donor, Long> {
    // You can add custom queries here if needed, e.g.
    // List<Donor> findByCity(String city);
}

