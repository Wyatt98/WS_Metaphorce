package mx.com.udes.metaphorce.service;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.udes.metaphorce.model.Employee;
import mx.com.udes.metaphorce.repository.EmployeeRepository;
import mx.com.udes.metaphorce.validations.Validations;
import mx.com.udes.metaphorceResponses.ErrorsResponse;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public ResponseEntity<?> getActiveEmployees() {
		return employeeRepository.getActiveEmployees();
	}
	
	public ResponseEntity<?> saveEmployee(Employee employee) {
		Validations validations = new Validations();
		
		if(validations.validateRfc(employee.getTaxIdNumber())) {
			BigInteger existe = employeeRepository.getEmployeeByRFC(employee.getTaxIdNumber());
			
			if(existe.intValue() == 1) {
				return ErrorsResponse.badRequestError("El empleado ya existe");
			} else if(existe.intValue() == 0) {				
				employee.setDateCreated(LocalDateTime.now());
				employee.setIsActive(true);
				
				return employeeRepository.save(employee);
			} else {
				return ErrorsResponse.internalServerError();
			}
		} else {
			return ErrorsResponse.badRequestError("El RFC no tiene el formato correcto");
		}
	}
	
}
