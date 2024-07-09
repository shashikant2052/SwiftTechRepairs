package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BookingsRepository;
import com.model.Bookings;

@Service
public class BookingsServiceImpl {

    @Autowired
    private BookingsRepository bookingsRepository;

    public List<Bookings> findAll() {
        return bookingsRepository.findAll();
    }

    public Optional<Bookings> findById(Long id) {
        return bookingsRepository.findById(id);
    }

    public Bookings save(Bookings bookings) {
        return bookingsRepository.save(bookings);
    }

    public void deleteById(Long id) {
        bookingsRepository.deleteById(id);
    }
}
