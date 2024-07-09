package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.ServiceProvider;
import com.service.ServiceProviderServiceImpl;



@RestController
@RequestMapping("/serviceproviders")
public class ServiceProviderController  {
	@Autowired
    private ServiceProviderServiceImpl serviceProviderService;

    @GetMapping
    public List<ServiceProvider> getAllServiceProviders() {
        return serviceProviderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProvider> getServiceProviderById(@PathVariable Long id) {
        Optional<ServiceProvider> serviceProvider = serviceProviderService.findById(id);
        if (serviceProvider.isPresent()) {
            return ResponseEntity.ok(serviceProvider.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ServiceProvider createServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        return serviceProviderService.save(serviceProvider);
    }
	
	

}