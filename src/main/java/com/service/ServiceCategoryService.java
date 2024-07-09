package com.service;

import java.util.List;

import com.model.ServiceCategory;

public interface ServiceCategoryService {
	
	public ServiceCategory saveCategory(ServiceCategory category);
	
	public ServiceCategory getCategoryById(Long id) ;
	
	 public List<ServiceCategory> getAllCategories() ;
	 
	 public void deleteCategory(Long id);
	

}
