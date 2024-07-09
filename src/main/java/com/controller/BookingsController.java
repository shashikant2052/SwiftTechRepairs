package com.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Bookings;
import com.service.BookingsServiceImpl;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsServiceImpl bookingsService;

    @GetMapping
    public List<Bookings> getAllBookings() {
        return bookingsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable Long id) {
        Optional<Bookings> bookings = bookingsService.findById(id);
        if (bookings.isPresent()) {
            return ResponseEntity.ok(bookings.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Bookings createBooking(@RequestBody Bookings bookings) {
        return bookingsService.save(bookings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bookings> updateBooking(@PathVariable Long id, @RequestBody Bookings bookingDetails) {
        Optional<Bookings> bookings = bookingsService.findById(id);
        if (bookings.isPresent()) {
            Bookings updatedBookings = bookings.get();
            updatedBookings.setCustomer(bookingDetails.getCustomer());
            updatedBookings.setService(bookingDetails.getService());
            updatedBookings.setScheduledDate(bookingDetails.getScheduledDate());
            updatedBookings.setStatus(bookingDetails.getStatus());
            updatedBookings.setTotalPrice(bookingDetails.getTotalPrice());
            updatedBookings.setNotes(bookingDetails.getNotes());
            return ResponseEntity.ok(bookingsService.save(updatedBookings));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}