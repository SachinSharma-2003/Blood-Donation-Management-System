package com.example.Blood_Donation_Management.controller;


import com.example.Blood_Donation_Management.Repo.DonorRepo;
import com.example.Blood_Donation_Management.entity.Donor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
@RestController
@RequestMapping("/api/donors")
public class DonorController {

    @Autowired
    private DonorRepo donorRepo;

    // ✅ Get all donors
    @GetMapping
    public List<Donor> getAllDonors() {
        return donorRepo.findAll();
    }

    // ✅ Add a new donor
    @PostMapping
    public Donor addDonor(@RequestBody Donor donor) {
        return donorRepo.save(donor);
    }

    // ✅ Get donor by ID
    @GetMapping("/{id}")
    public Donor getDonorById(@PathVariable Long id) {
        return donorRepo.findById(id).orElse(null);
    }

    // ✅ Update donor
    @PutMapping("/{id}")
    public Donor updateDonor(@PathVariable Long id, @RequestBody Donor donorDetails) {
        Donor donor = donorRepo.findById(id).orElse(null);
        if (donor != null) {
            donor.setName(donorDetails.getName());
            donor.setBloodGroup(donorDetails.getBloodGroup());
            donor.setCity(donorDetails.getCity());
            donor.setPhone(donorDetails.getPhone());
            donor.setLastDonation(donorDetails.getLastDonation());
            donor.setAvailable(donorDetails.isAvailable());
            return donorRepo.save(donor);
        }
        return null;
    }

    // ✅ Delete donor
    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorRepo.deleteById(id);
        return "Donor with ID " + id + " deleted successfully!";
    }
}

