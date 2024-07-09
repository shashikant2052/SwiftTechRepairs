package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Services;
import com.service.ServicesServiceImpl;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesServiceImpl servicesService;
    
    
    @PostMapping
    public Services createService(@RequestBody Services service) {
        return servicesService.createService(service);
    }

    @GetMapping
    public List<Services> getAllServices() {
        return servicesService.getAllServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> getServiceById(@PathVariable Long id) {
        Optional<Services> services = servicesService.getServiceById(id);
        if (services.isPresent()) {
            return ResponseEntity.ok(services.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
/*
    @PutMapping("/{id}")
    public ResponseEntity<Services> updateService(@PathVariable Long id, @RequestBody Services servicesDetails) throws NotFoundException {
        Optional<Services> services = servicesService.findById(id);
        if (services.isPresent()) {
            Services updatedServices = services.get();
            updatedServices.setServiceName(servicesDetails.getServiceName());
            updatedServices.setDescription(servicesDetails.getDescription());
            updatedServices.setPrice(servicesDetails.getPrice());
            updatedServices.setEstimatedTime(servicesDetails.getEstimatedTime());
            updatedServices.setServiceProvider(servicesDetails.getServiceProvider());
            updatedServices.setServiceCategory(servicesDetails.getServiceCategory());
            return ResponseEntity.ok(servicesService.saveService(updatedServices));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   */ 
    
 }
