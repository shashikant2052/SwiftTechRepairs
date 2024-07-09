package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminRepository;
import com.model.Admin;

@Service
public class AdminServiceImpl {
	  @Autowired
	    private AdminRepository adminRepo;
	  
	  @Transactional(readOnly = true)
	    public Admin getAdminWithCustomers(Long adminId) {
	        Admin admin = adminRepo.findById(adminId).orElseThrow();
	        admin.getCustomers().size(); // This will initialize the collection
	        return admin;
	    }

	    @Transactional(readOnly = true)
	    public List<Admin> getAllAdmins() {
	        return adminRepo.findAll();
	    }

	    public Optional<Admin> getAdminById(Long adminId) {
	        return adminRepo.findById(adminId);
	    }

	    public Admin createAdmin(Admin admin) {
	        return adminRepo.save(admin);
	    }

	    public Admin updateAdmin(Long adminId, Admin adminDetails) {
	        Admin admin = adminRepo.findById(adminId)
	                .orElseThrow(() -> new RuntimeException("Admin not found for this id :: " + adminId));

	        admin.setAdminName(adminDetails.getAdminName());
	        admin.setAdminEmail(adminDetails.getAdminEmail());
	        admin.setAdminPassword(adminDetails.getAdminPassword());
	        admin.setCustomers(adminDetails.getCustomers());
	        admin.setServiceProviders(adminDetails.getServiceProviders());

	        return adminRepo.save(admin);
	    }

	    public void deleteAdmin(Long adminId) {
	        Admin admin = adminRepo.findById(adminId)
	                .orElseThrow(() -> new RuntimeException("Admin not found for this id :: " + adminId));
	        
	        adminRepo.delete(admin);
	    }

}
