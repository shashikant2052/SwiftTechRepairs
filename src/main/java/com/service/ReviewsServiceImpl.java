package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReviewsRepository;
import com.model.Reviews;

@Service
public class ReviewsServiceImpl {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<Reviews> findAll() {
        return reviewsRepository.findAll();
    }

    public Optional<Reviews> findById(Long id) {
        return reviewsRepository.findById(id);
    }

    public Reviews save(Reviews reviews) {
        return reviewsRepository.save(reviews);
    }

    public void deleteById(Long id) {
        reviewsRepository.deleteById(id);
    }
}

