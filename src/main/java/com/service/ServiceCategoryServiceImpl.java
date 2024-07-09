package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ServiceCategoryRepository;
import com.model.ServiceCategory;
@Service
public class ServiceCategoryServiceImpl implements ServiceCategoryService{
	
	 @Autowired
	    private ServiceCategoryRepository servicecategoryrepo;

	    public List<ServiceCategory> getAllCategories() {
	        return servicecategoryrepo.findAll();
	    }

	    public ServiceCategory getCategoryById(Long id) {
	        return servicecategoryrepo.findById(id).orElse(null);
	    }

	    public ServiceCategory saveCategory(ServiceCategory category) {
	        return servicecategoryrepo.save(category);
	    }

	    public void deleteCategory(Long id) {
	        servicecategoryrepo.deleteById(id);
	    }

	   
}
