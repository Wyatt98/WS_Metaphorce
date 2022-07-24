package mx.com.udes.metaphorce.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.udes.metaphorce.model.Contract;
import mx.com.udes.metaphorce.service.ContractService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping(path = "/api/contract")
public class ContractController {

	@Autowired
	ContractService contractService;
	
	@PostMapping
	public ResponseEntity<?> saveContract(@RequestBody Contract contract) {
		return contractService.saveContract(contract);
	}
	
	@DeleteMapping(path = "/{employeeId}")
	public ResponseEntity<?> deleteContract(@PathVariable BigInteger employeeId) { 
		return contractService.deleteContract(employeeId);
	}
}
