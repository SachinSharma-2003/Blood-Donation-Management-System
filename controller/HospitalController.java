package com.example.Blood_Donation_Management.controller;

import com.example.Blood_Donation_Management.entity.Hospitals;
import com.example.Blood_Donation_Management.Repo.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000") // allow React frontend
@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    @Autowired
    private HospitalRepo hospitalRepo;

    // ✅ Get all hospitals
    @GetMapping
    public List<Hospitals> getAllHospitals() {
        return hospitalRepo.findAll();
    }

    // ✅ Add a new hospital
    @PostMapping
    public Hospitals addHospital(@RequestBody Hospitals hospital) {
        return hospitalRepo.save(hospital);
    }

    // ✅ Get hospital by ID
    @GetMapping("/{id}")
    public Hospitals getHospitalById(@PathVariable Long id) {
        return hospitalRepo.findById(id).orElse(null);
    }

    // ✅ Update hospital
    @PutMapping("/{id}")
    public Hospitals updateHospital(@PathVariable Long id, @RequestBody Hospitals hospitalDetails) {
        Hospitals hospital = hospitalRepo.findById(id).orElse(null);
        if (hospital != null) {
            hospital.setHospital_name(hospitalDetails.getHospital_name());
            hospital.setCity(hospitalDetails.getCity());
            hospital.setPhone_number(hospitalDetails.getPhone_number());
            hospital.setFull_address(hospitalDetails.getFull_address());
            hospital.setOfficial_email_address(hospitalDetails.getOfficial_email_address());
            hospital.setPassword(hospitalDetails.getPassword());
            return hospitalRepo.save(hospital);
        }
        return null;
    }

    // ✅ Delete hospital
    @DeleteMapping("/{id}")
    public String deleteHospital(@PathVariable Long id) {
        hospitalRepo.deleteById(id);
        return "Hospital with ID " + id + " deleted successfully!";
    }
}

