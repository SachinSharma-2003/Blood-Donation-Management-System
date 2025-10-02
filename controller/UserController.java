package com.example.Blood_Donation_Management.controller;

import com.example.Blood_Donation_Management.entity.User;
import com.example.Blood_Donation_Management.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; // Import the logger

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class); // Initialize the logger

    @Autowired
    private UserRepo userRepository;

    @PostMapping("/signup")
    public User registerUser(@RequestBody User user) {
        logger.info("Received user for signup: {}", user.toString()); // Log the received user object
        return userRepository.save(user);
    }

    // ✅ Login
    @PostMapping("/login")
    public User loginUser(@RequestBody User loginRequest) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return user; // ✅ Successful login, return user data
            }
        }
        throw new RuntimeException("Invalid email or password");
    }
}