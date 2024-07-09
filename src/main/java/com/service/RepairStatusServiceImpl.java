package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RepairStatusRepository;
import com.model.RepairStatus;
@Service
public class RepairStatusServiceImpl {




    @Autowired
    private RepairStatusRepository repairStatusRepository;

    public List<RepairStatus> findAll() {
        return repairStatusRepository.findAll();
    }

    public Optional<RepairStatus> findById(Long id) {
        return repairStatusRepository.findById(id);
    }

    public RepairStatus save(RepairStatus repairStatus) {
        return repairStatusRepository.save(repairStatus);
    }

    public void deleteById(Long id) {
        repairStatusRepository.deleteById(id);
    }

}
