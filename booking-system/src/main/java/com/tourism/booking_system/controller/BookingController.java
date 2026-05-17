package com.tourism.booking_system.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.booking_system.model.Booking;
import com.tourism.booking_system.repository.BookingRepository;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    // 1. SAVE NEW BOOKING
    @PostMapping
    public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
        System.out.println("--- NEW BOOKING REQUEST ---");
        System.out.println("User: " + booking.getUserEmail());
        try {
            booking.setBookingDate(LocalDate.now());
            bookingRepository.save(booking);
            System.out.println("RESULT: Booking Saved Successfully!");
            return ResponseEntity.ok("Booking Confirmed");
        } catch (Exception e) {
            System.out.println("RESULT: Error saving booking.");
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error saving booking");
        }
    }

    // 2. GET BOOKINGS FOR SPECIFIC USER
@GetMapping("/{email}")
public ResponseEntity<List<Booking>> getUserBookings(@PathVariable String email) {
    System.out.println("--- FETCHING BOOKINGS FOR: " + email + " ---");
    
    // 🟢 THIS IS FAST: Database gives only the exact matches
    List<Booking> userBookings = bookingRepository.findByUserEmail(email);
    
    System.out.println("Found " + userBookings.size() + " bookings.");
    return ResponseEntity.ok(userBookings);
}

    // 3. ADMIN: GET ALL BOOKINGS
    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() {
        System.out.println("--- ADMIN REQUESTING ALL DATA ---");
        return ResponseEntity.ok(bookingRepository.findAll());
    }
}