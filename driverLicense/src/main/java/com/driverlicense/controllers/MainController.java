package com.driverlicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.driverlicense.models.License;
import com.driverlicense.models.Person;
import com.driverlicense.services.LicenseService;
import com.driverlicense.services.PersonService;

@Controller
public class MainController {
	//dependency injection
	@Autowired
	private PersonService personService;
	
	@Autowired
	private LicenseService licenseService;
	
	//ROUTES - same as the APIcontroller
//	@RequestMapping("/", method=RequestMethod.GET)
//	@RequestMapping("/")
	@GetMapping("/")
	public String index() {
		return "redirect:/dashboard";
	}
	
	@GetMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {//need model to display to frontend from DB
//		List<Person> allDLs = this.DLService.getAllDLs();//store everything in a list
//		viewModel.addAttribute("allDLs", allDLs);
		
		return "add.jsp";
	}
	
	@GetMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model viewModel) {//need model to display to frontend from DB
		List<Person> allPersons = this.personService.getAllPersons();//store everything in a list
		viewModel.addAttribute("allPersons", allPersons);
		
		return "addLicense.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model viewModel) {//need model to display to frontend from DB
		List<Person> allDLs = this.personService.getAllPersons();//store everything in a list
		viewModel.addAttribute("allDLs", allDLs);
		
		return "dashboard.jsp";
	}
	

	//Create new person	
	@PostMapping("/add")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		//the @Valid will check against the validations created in DL.java
		//BindingResult is if something goes wrong in the validation from the DLs, BindingResult will catch it
		if(result.hasErrors()) {
			return "add.jsp";//re-render the page if there are errors
		}
		this.personService.createPerson(person);
		return "redirect:/dashboard";
	}
	
	//Create new license
	@PostMapping("/addLicense")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "addLicense.jsp";//re-render the page if there are errors
		}
	 
		this.licenseService.createLicense(license);
		return "redirect:/dashboard";
	}

	//show individual person with license info
	@GetMapping("/person/{id}")
	public String displayDL(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("person", personService.getSinglePerson(id));
		
		return "show.jsp";
	}

	//delete
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable("id") Long id) {
		this.personService.deletePerson(id);
		
		return "redirect:/dashboard";
	}

	
}
