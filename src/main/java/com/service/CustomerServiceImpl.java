package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerRepository;
import com.model.Customer;

@Service
public class CustomerServiceImpl {
	
	@Autowired
	private CustomerRepository customerRepo;

	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepo.findAll() ;
	}

	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepo.save(customer);
	}

	public Optional<Customer> findById(Long id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(id);
	}

}
