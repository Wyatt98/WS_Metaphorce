package mx.com.udes.metaphorce.service;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import mx.com.udes.metaphorce.model.Contract;
import mx.com.udes.metaphorce.repository.ContractRepository;
import mx.com.udes.metaphorceResponses.ErrorsResponse;

@Service
public class ContractService {

	@Autowired
	ContractRepository contractRepository;
	
	public ResponseEntity<?> saveContract(Contract contract) {
		
		BigInteger contractFound = contractRepository.findContractByEmployee(contract.getEmployee().getEmployeeId());
		contract.setIsActive(true);
		contract.setDateCreated(LocalDateTime.now());
		
		if(contractFound.intValue() == 0) {
			return contractRepository.saveContract(contract);
		} else if(contractFound.intValue() == -1) {
			return ErrorsResponse.internalServerError();
		} else {
			contractRepository.updateContract(contractFound.intValue());
			return contractRepository.saveContract(contract);
		}
	}
	
	public ResponseEntity<?> deleteContract(BigInteger employeeId) {
		BigInteger contractFound = contractRepository.findContractByEmployee(employeeId.intValue());
		
		if(contractFound != null) {
			if(contractFound.intValue() == 0) {
				return ErrorsResponse.badRequestError("Error: El empleado tiene algún contrato");
			} else {
				return contractRepository.updateContract(contractFound.intValue());
			}
		} else {
			return ErrorsResponse.badRequestError("El empleado que enviaste no es válido");
		}
	}
	
}
