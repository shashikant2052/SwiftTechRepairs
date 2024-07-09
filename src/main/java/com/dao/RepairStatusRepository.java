package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.RepairStatus;

public interface RepairStatusRepository extends JpaRepository<RepairStatus,Long> {

	List<RepairStatus> findAll();

}
