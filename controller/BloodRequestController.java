package com.example.Blood_Donation_Management.controller;

import com.example.Blood_Donation_Management.entity.BloodRequest;
import com.example.Blood_Donation_Management.Repo.BloodRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/blood-requests")
public class BloodRequestController {

    @Autowired
    private BloodRequestRepo bloodRequestRepo;

    // A simple DTO to hold the summary statistics
    public static class BloodRequestSummary {
        private long totalRequests;
        private long fulfilledRequests;
        private long unfulfilledRequests;
        private long totalUnitsNeeded;

        // Getters and Setters
        public long getTotalRequests() { return totalRequests; }
        public void setTotalRequests(long totalRequests) { this.totalRequests = totalRequests; }
        public long getFulfilledRequests() { return fulfilledRequests; }
        public void setFulfilledRequests(long fulfilledRequests) { this.fulfilledRequests = fulfilledRequests; }
        public long getUnfulfilledRequests() { return unfulfilledRequests; }
        public void setUnfulfilledRequests(long unfulfilledRequests) { this.unfulfilledRequests = unfulfilledRequests; }
        public long getTotalUnitsNeeded() { return totalUnitsNeeded; }
        public void setTotalUnitsNeeded(long totalUnitsNeeded) { this.totalUnitsNeeded = totalUnitsNeeded; }
    }

    // --- New Endpoint for Summary Statistics ---
    @GetMapping("/summary")
    public BloodRequestSummary getBloodRequestSummary() {
        List<BloodRequest> allRequests = bloodRequestRepo.findAll();
        long totalRequests = allRequests.size();
        long fulfilledRequests = allRequests.stream()
            .filter(request -> "Fulfilled".equalsIgnoreCase(request.getStatus()))
            .count();
        long unfulfilledRequests = totalRequests - fulfilledRequests;
        long totalUnitsNeeded = allRequests.stream()
            .mapToLong(BloodRequest::getUnitsRequired)
            .sum();

        BloodRequestSummary summary = new BloodRequestSummary();
        summary.setTotalRequests(totalRequests);
        summary.setFulfilledRequests(fulfilledRequests);
        summary.setUnfulfilledRequests(unfulfilledRequests);
        summary.setTotalUnitsNeeded(totalUnitsNeeded);

        return summary;
    }

    // ✅ Get all requests
    @GetMapping
    public List<BloodRequest> getAllRequests() {
        return bloodRequestRepo.findAll();
    }

    // ✅ Add new blood request
    @PostMapping
    public BloodRequest addRequest(@RequestBody BloodRequest request) {
        return bloodRequestRepo.save(request);
    }

    // ✅ Get request by ID
    @GetMapping("/{id}")
    public BloodRequest getRequestById(@PathVariable Long id) {
        return bloodRequestRepo.findById(id).orElse(null);
    }

    // ✅ Update blood request
    @PutMapping("/{id}")
    public BloodRequest updateRequest(@PathVariable Long id, @RequestBody BloodRequest requestDetails) {
        BloodRequest request = bloodRequestRepo.findById(id).orElse(null);
        if (request != null) {
            request.setHospitalName(requestDetails.getHospitalName());
            request.setCity(requestDetails.getCity());
            request.setBloodGroup(requestDetails.getBloodGroup());
            request.setUnitsRequired(requestDetails.getUnitsRequired());
            request.setUrgencyLevel(requestDetails.getUrgencyLevel());
            request.setAdditionalInfo(requestDetails.getAdditionalInfo());
            request.setRequestDate(requestDetails.getRequestDate());
            return bloodRequestRepo.save(request);
        }
        return null;
    }

    // ✅ New endpoint to update the status of a specific blood request
    @PutMapping("/{id}/status")
    public BloodRequest updateRequestStatus(@PathVariable Long id, @RequestBody Map<String, String> statusUpdate) {
        return bloodRequestRepo.findById(id).map(request -> {
            String newStatus = statusUpdate.get("status");
            if (newStatus != null) {
                request.setStatus(newStatus);
            }
            return bloodRequestRepo.save(request);
        }).orElseThrow(() -> new RuntimeException("Request not found with id " + id));
    }

    // ✅ Delete request
    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {
        bloodRequestRepo.deleteById(id);
        return "Blood Request with ID " + id + " deleted successfully!";
    }
}
