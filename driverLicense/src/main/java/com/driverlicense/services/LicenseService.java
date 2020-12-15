package com.driverlicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.driverlicense.models.License;
import com.driverlicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	//Dependency Injection
	private LicenseRepository licenseRepo;
	
	//constructor
	public LicenseService(LicenseRepository repo) {
		this.licenseRepo = repo;
	}
	
	//CRUD Methods
	//Get All licenses
	public List<License> getAllLicenses(){
		return this.licenseRepo.findAll();
	}
	
	//Get one license
	public License getSingleLicense(Long id) {
		return this.licenseRepo.findById(id).orElse(null);
	}

	//Create a license
	public License createLicense(License newLicense) {
		newLicense.setNumber(this.createLicenseNumber());
		return this.licenseRepo.save(newLicense);
	}
	
	//create License number
	public String createLicenseNumber() {
		License license = licenseRepo.findTopByOrderByNumberDesc();//retrieve the most recent license in DB
		
		if(license == null)
			return "000001";
		else{
			int newLicenseNumberUnformatted = Integer.parseInt(license.getNumber());//get most recent license in DB and convert to int
			newLicenseNumberUnformatted++;//increment by one
			
			String newLicenseNumber = Integer.toString(newLicenseNumberUnformatted);//convert to string
			
			int numOfZeros = 6-String.valueOf(newLicenseNumberUnformatted).length();//get num of digits excluding leading zeros
			
			//prepend zeros in front of license number
			for (int i = 0; i < numOfZeros; i++) {
				newLicenseNumber = "0" + newLicenseNumber;
			}
			
			return newLicenseNumber;
		}
	}

}
