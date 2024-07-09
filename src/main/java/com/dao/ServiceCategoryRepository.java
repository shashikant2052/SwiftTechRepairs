package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.ServiceCategory;

@Repository
public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Long>  {

}
