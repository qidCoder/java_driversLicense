package com.driverlicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.driverlicense.models.Person;
import com.driverlicense.repositories.PersonRepository;

@Service
public class PersonService {
	//Dependency Injection
	private PersonRepository personRepo;
	
	//constructor
	public PersonService(PersonRepository repo) {
		this.personRepo = repo;
	}
	
	//CRUD Methods
	//Get All persons
	public List<Person> getAllPersons(){
		return this.personRepo.findAll();
	}
	
	//Get one person
	public Person getSinglePerson(Long id) {
		return this.personRepo.findById(id).orElse(null);
	}
	
	//Create a person
	public Person createPerson(Person newPerson) {
		return this.personRepo.save(newPerson);
	}

	
	//Delete a person
	public void deletePerson(Long id) {
		this.personRepo.deleteById(id);
	}
}
