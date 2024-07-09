package com.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class RepairStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "booking_id", nullable = false)
    private Bookings booking;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RepairStatusEnum status;

    @Column(name = "updated_at", nullable = false, updatable = false)
    private LocalDateTime updatedAt;

    private String remarks;

    @PrePersist
    protected void onCreate() {
        updatedAt = LocalDateTime.now();
    }

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}

	public RepairStatusEnum getStatus() {
		return status;
	}

	public void setStatus(RepairStatusEnum status) {
		this.status = status;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

    // Getters and Setters
    // ...
    
    
}

enum RepairStatusEnum {
    RECEIVED, IN_PROGRESS, REPAIRED, DELIVERED
}