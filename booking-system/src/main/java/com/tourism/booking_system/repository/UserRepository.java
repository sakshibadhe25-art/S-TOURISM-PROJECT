package com.tourism.booking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Ensure this import matches your model package
import org.springframework.stereotype.Repository;

import com.tourism.booking_system.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Add this line to fix the "undefined" error
    boolean existsByEmail(String email);
    
    // You likely also need this for login
    User findByEmail(String email);
}