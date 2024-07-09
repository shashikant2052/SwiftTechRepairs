package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.model.ServiceCategory;
import com.service.ServiceCategoryService;
@RestController
@RequestMapping("/categories")
public class ServiceCategoryController {

    @Autowired
    ServiceCategoryService service;

    @GetMapping("/getAll")
    public List<ServiceCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<ServiceCategory> getCategoryById(@PathVariable Long id) {
        ServiceCategory category = service.getCategoryById(id);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ServiceCategory> createCategory(@RequestBody ServiceCategory category) {
        return new ResponseEntity<>(service.saveCategory(category), HttpStatus.CREATED);
    }



    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}