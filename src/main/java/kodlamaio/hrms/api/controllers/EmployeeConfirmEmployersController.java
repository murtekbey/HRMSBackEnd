package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployer;

@RestController
@RequestMapping("/api/employeeConfirmEmployers")
public class EmployeeConfirmEmployersController {
	private EmployeeConfirmEmployerService employeeConfirmEmployerService;

	@Autowired
	public EmployeeConfirmEmployersController(EmployeeConfirmEmployerService employeeConfirmEmployerService) {
		super();
		this.employeeConfirmEmployerService = employeeConfirmEmployerService;
	}
	
	@PostMapping("/confirmUser")
	public Result confirmUser(@Valid @RequestBody EmployeeConfirmEmployer employeeConfirmEmployer) {
		return this.employeeConfirmEmployerService.confirmUser(employeeConfirmEmployer);
	}
}
