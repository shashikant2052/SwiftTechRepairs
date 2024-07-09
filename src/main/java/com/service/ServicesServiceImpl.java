package com.service;


import com.model.Services;
import com.dao.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesServiceImpl {

    @Autowired
    private ServicesRepository servicesRepository;

    @Transactional(readOnly = true)
    public List<Services> getAllServices() {
        return servicesRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Services> getServiceById(Long id) {
        return servicesRepository.findById(id);
    }

    @Transactional
    public Services createService(Services service) {
        return servicesRepository.save(service);
    }

    @Transactional
    public Services updateService(Long id, Services serviceDetails) {
        Services service = servicesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
        
        service.setServiceName(serviceDetails.getServiceName());
        service.setDescription(serviceDetails.getDescription());
        service.setPrice(serviceDetails.getPrice());
        service.setEstimatedTime(serviceDetails.getEstimatedTime());
        service.setServiceCategory(serviceDetails.getServiceCategory());
        service.setServiceProvider(serviceDetails.getServiceProvider());
        
        return servicesRepository.save(service);
    }

    @Transactional
    public void deleteService(Long id) {
        servicesRepository.deleteById(id);
    }
}