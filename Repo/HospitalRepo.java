package com.example.Blood_Donation_Management.Repo;


import com.example.Blood_Donation_Management.entity.Hospitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospitals, Long> {
}
