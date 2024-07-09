package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Reviews;

public interface ReviewsRepository extends JpaRepository<Reviews, Long> {

}
