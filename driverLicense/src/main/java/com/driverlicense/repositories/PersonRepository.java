package com.driverlicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.driverlicense.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	//SELECT * FROM DLs
	List<Person> findAll();
}
