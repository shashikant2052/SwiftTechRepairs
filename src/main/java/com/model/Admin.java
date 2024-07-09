package com.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    private String adminName;
    private String adminEmail;
    private String adminPassword;

    @OneToMany( fetch = FetchType.LAZY)
    
    private Set<Customer> customers;

    @OneToMany( fetch = FetchType.LAZY)
    
    private Set<ServiceProvider> serviceProviders;

    
    
    
    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	public Admin(Long adminId, String adminName, String adminEmail, String adminPassword, Set<Customer> customers,
			Set<ServiceProvider> serviceProviders) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.customers = customers;
		this.serviceProviders = serviceProviders;
	}



	public Long getAdminId() {
		return adminId;
	}



	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}



	public String getAdminName() {
		return adminName;
	}



	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}



	public String getAdminEmail() {
		return adminEmail;
	}



	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}



	public String getAdminPassword() {
		return adminPassword;
	}



	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}



	public Set<Customer> getCustomers() {
		return customers;
	}



	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}



	public Set<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}



	public void setServiceProviders(Set<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}
	
	



}