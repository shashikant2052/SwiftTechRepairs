package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Reviews;
import com.service.ReviewsServiceImpl;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsServiceImpl reviewsService;

    @GetMapping
    public List<Reviews> getAllReviews() {
        return reviewsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long id) {
        Optional<Reviews> reviews = reviewsService.findById(id);
        if (reviews.isPresent()) {
            return ResponseEntity.ok(reviews.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Reviews createReview(@RequestBody Reviews reviews) {
        return reviewsService.save(reviews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reviews> updateReview(@PathVariable Long id, @RequestBody Reviews reviewsDetails) {
        Optional<Reviews> reviews = reviewsService.findById(id);
        if (reviews.isPresent()) {
            Reviews updatedReviews = reviews.get();
            updatedReviews.setRating(reviewsDetails.getRating());
            updatedReviews.setComment(reviewsDetails.getComment());
            updatedReviews.setCustomer(reviewsDetails.getCustomer());
            updatedReviews.setServiceProvider(reviewsDetails.getServiceProvider());
            return ResponseEntity.ok(reviewsService.save(updatedReviews));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
