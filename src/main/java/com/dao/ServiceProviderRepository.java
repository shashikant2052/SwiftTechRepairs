package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ServiceProvider;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
}