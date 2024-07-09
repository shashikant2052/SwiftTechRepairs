package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Admin;
import com.service.AdminServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;
    

    @GetMapping("/getAll")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
//        Admin updatedAdmin = adminService.updateAdmin(id, adminDetails);
//        return ResponseEntity.ok(updatedAdmin);
  //  }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Optional<Admin> admin = adminService.getAdminById(id);
        if (admin.isPresent()) {
            Admin updatedAdmin = admin.get();
            updatedAdmin.setAdminName(adminDetails.getAdminName());
            updatedAdmin.setAdminEmail(adminDetails.getAdminEmail());
            updatedAdmin.setAdminPassword(adminDetails.getAdminPassword());
            return ResponseEntity.ok(adminService.createAdmin(updatedAdmin));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.noContent().build();
    }
    /*
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Optional<Admin> admin = adminService.findById(id);
        if (admin.isPresent()) {
            return ResponseEntity.ok(admin.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Optional<Admin> admin = adminService.findById(id);
        if (admin.isPresent()) {
            Admin updatedAdmin = admin.get();
            updatedAdmin.setAdminName(adminDetails.getAdminName());
            updatedAdmin.setAdminEmail(adminDetails.getAdminEmail());
            updatedAdmin.setAdminPassword(adminDetails.getAdminPassword());
            return ResponseEntity.ok(adminService.save(updatedAdmin));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    */
}