package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.RepairStatus;
import com.service.RepairStatusServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/repair-status")
public class RepairStatusController {

    @Autowired
    private RepairStatusServiceImpl repairStatusService;

    @GetMapping
    public List<RepairStatus> getAllRepairStatuses() {
        return repairStatusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepairStatus> getRepairStatusById(@PathVariable Long id) {
        Optional<RepairStatus> repairStatus = repairStatusService.findById(id);
        if (repairStatus.isPresent()) {
            return ResponseEntity.ok(repairStatus.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public RepairStatus createRepairStatus(@RequestBody RepairStatus repairStatus) {
        return repairStatusService.save(repairStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RepairStatus> updateRepairStatus(@PathVariable Long id, @RequestBody RepairStatus repairStatusDetails) {
        Optional<RepairStatus> repairStatus = repairStatusService.findById(id);
        if (repairStatus.isPresent()) {
            RepairStatus updatedRepairStatus = repairStatus.get();
            updatedRepairStatus.setStatus(repairStatusDetails.getStatus());
            updatedRepairStatus.setRemarks(repairStatusDetails.getRemarks());
            updatedRepairStatus.setBooking(repairStatusDetails.getBooking());
            return ResponseEntity.ok(repairStatusService.save(updatedRepairStatus));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepairStatus(@PathVariable Long id) {
        repairStatusService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}