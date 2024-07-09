package com.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ServiceProvider {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    private String name;
    private String contact;
    private String servicesOffered;
    
    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Reviews> reviews;
    
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Services > serivces;

	public Long getProviderId() {
		return providerId;
	}

	public void setProviderId(Long providerId) {
		this.providerId = providerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getServicesOffered() {
		return servicesOffered;
	}

	public void setServicesOffered(String servicesOffered) {
		this.servicesOffered = servicesOffered;
	}

	
	

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}
	
	public List<Services> getSerivces() {
		return serivces;
	}

	public void setSerivces(List<Services> serivces) {
		this.serivces = serivces;
	}

    
	    
}
