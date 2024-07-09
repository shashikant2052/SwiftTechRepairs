package com.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class ServiceCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;
    
    @ManyToOne
    private Services serivces;
    
    


   
    public ServiceCategory() {}

    public ServiceCategory(String categoryName) {
        this.categoryName = categoryName;
    }

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Services getSerivces() {
		return serivces;
	}

	public void setSerivces(Services serivces) {
		this.serivces = serivces;
	}

    
}
