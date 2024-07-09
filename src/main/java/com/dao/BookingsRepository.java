package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Bookings;

public interface BookingsRepository extends JpaRepository<Bookings, Long> {

	List<Bookings> findAll();

}
