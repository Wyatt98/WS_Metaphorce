package mx.com.udes.metaphorce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.udes.metaphorce.model.Employee;
import mx.com.udes.metaphorce.service.EmployeeService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(path = "/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<?> getAllEmployees() {
		return employeeService.getActiveEmployees();
	}
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
}
