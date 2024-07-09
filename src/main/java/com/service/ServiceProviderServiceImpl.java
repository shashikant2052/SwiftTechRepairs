package com.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ServiceProviderRepository;



import com.model.ServiceProvider;

@Service
public class ServiceProviderServiceImpl {
	

    @Autowired
    private ServiceProviderRepository serviceProviderRepo;

    public List<ServiceProvider> findAll() {
        return serviceProviderRepo.findAll();
    }

    public Optional<ServiceProvider> findById(Long id) {
        return serviceProviderRepo.findById(id);
    }

    public ServiceProvider save(ServiceProvider serviceProvider) {
        return serviceProviderRepo.save(serviceProvider);
    }
    public  ServiceProvider update(ServiceProvider serviceProvider) {
    	ServiceProvider sp=serviceProviderRepo.findById(serviceProvider.getProviderId()).orElse(null);
		
		sp.setName( serviceProvider.getName());
		
		
		return serviceProviderRepo.save(sp);
	}

    public void deleteById(Long id) {
        serviceProviderRepo.deleteById(id);
    }

}
