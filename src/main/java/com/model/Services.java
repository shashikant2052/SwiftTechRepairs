package com.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Services {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    
    @ManyToOne
    @JsonBackReference // Use this if ServiceProvider has a back-reference to Services
    @JoinColumn(name = "provider_id", nullable = false)
    private ServiceProvider serviceProvider;

    @ManyToOne
    @JsonBackReference // Use this if ServiceCategory has a back-reference to Services
    @JoinColumn(name = "category_id", nullable = false)
    private ServiceCategory serviceCategory;

    @Column(nullable = false)
    private String serviceName;

    private String description;

    @Column(nullable = false)
    private Double price;

    private String estimatedTime;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Bookings> bookings;

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}
		//ServiceProvider serviceProvider,
	public Services(Long serviceId,  ServiceCategory serviceCategory,
			String serviceName, String description, Double price, String estimatedTime, Set<Bookings> bookings) {
		super();
		this.serviceId = serviceId;
		this.serviceProvider = serviceProvider;
		this.serviceCategory = serviceCategory;
		this.serviceName = serviceName;
		this.description = description;
		this.price = price;
		this.estimatedTime = estimatedTime;
		this.bookings = bookings;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
	
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}
		
	public ServiceCategory getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(ServiceCategory serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Set<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Bookings> bookings) {
		this.bookings = bookings;
	}
	

    
}
