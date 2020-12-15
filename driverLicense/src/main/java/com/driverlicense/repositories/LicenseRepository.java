package com.driverlicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driverlicense.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	//SELECT * FROM DLs
	List<License> findAll();
	
    // retrieves first license in the database
    public License findTopByOrderByNumberDesc();
}
