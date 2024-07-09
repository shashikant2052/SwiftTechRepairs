package com.model;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JsonBackReference // To prevent infinite recursion
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JsonBackReference // To prevent infinite recursion
    @JoinColumn(name = "service_id", nullable = false)
    private Services service;

    @Column(name = "booking_date", nullable = false, updatable = false)
    private LocalDateTime bookingDate;

    @Column(name = "scheduled_date", nullable = false)
    private LocalDateTime scheduledDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;

    @Column(nullable = false)
    private Double totalPrice;

    private String notes;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // To manage serialization of repairStatuses
    private Set<RepairStatus> repairStatuses;

    @PrePersist
    protected void onCreate() {
        bookingDate = LocalDateTime.now();
        if (status == null) {
            status = BookingStatus.PENDING;
        }
    }

    // Constructors, Getters, and Setters

    public Bookings() {
        super();
    }

    public Bookings(Long bookingId, Customer customer, Services service, LocalDateTime bookingDate,
                    LocalDateTime scheduledDate, BookingStatus status, Double totalPrice, String notes,
                    Set<RepairStatus> repairStatuses) {
        super();
        this.bookingId = bookingId;
        this.customer = customer;
        this.service = service;
        this.bookingDate = bookingDate;
        this.scheduledDate = scheduledDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.notes = notes;
        this.repairStatuses = repairStatuses;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDateTime getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDateTime scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Set<RepairStatus> getRepairStatuses() {
        return repairStatuses;
    }

    public void setRepairStatuses(Set<RepairStatus> repairStatuses) {
        this.repairStatuses = repairStatuses;
    }
}

enum BookingStatus {
    PENDING, CONFIRMED, IN_PROGRESS, COMPLETED, CANCELLED
}
