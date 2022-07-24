package mx.com.udes.metaphorce.repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import mx.com.udes.metaphorce.model.Employee;
import mx.com.udes.metaphorceResponses.ContractResponse;
import mx.com.udes.metaphorceResponses.CustomResponse;
import mx.com.udes.metaphorceResponses.EmployeeResponse;
import mx.com.udes.metaphorceResponses.ErrorsResponse;

@Repository
public class EmployeeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public BigInteger getEmployeeByRFC(String rfc) {
		BigInteger result = new BigInteger("0");
		try {
			Query query = entityManager.createNativeQuery("SELECT COUNT(1) FROM employee WHERE tax_id_number = :rfc")
					.setParameter("rfc", rfc);
			
			result = (BigInteger) query.getSingleResult();
		} catch (Exception e) {
			result = new BigInteger("-1");
		} finally {
			entityManager.close();
		}
		
		return result;
	}
	
	@Transactional
	public ResponseEntity<?> save(Employee employee) {
		CustomResponse customResponse = new CustomResponse(true, null);
		
		try {
			if(employee.getEmployeeId() != 0) {
				entityManager.merge(employee);
				customResponse = new CustomResponse(true, "Empleado actualizado existosamente");
			} else {
				entityManager.persist(employee);
				customResponse = new CustomResponse(true, "Empleado registrado existosamente");
			}
		} catch (Exception e) {
			return ErrorsResponse.internalServerError();
		} finally {
			entityManager.close();
		}
		
		return ResponseEntity.ok().body(customResponse);
	}
	
	public ResponseEntity<?> getActiveEmployees() {
		List<EmployeeResponse> listEmployeesResponses = new ArrayList<>();
		ContractResponse contractResponse;
		EmployeeResponse employeeResponse;
		
		try {
			Query query = entityManager.createNativeQuery("SELECT CONCAT(e.name, ' ', e.last_name) as employeeName, e.tax_id_number, e.email, ct.name as ContractTypeName, c.date_from, c.date_to, c.salary_per_day FROM employee e\r\n"
					+ "LEFT JOIN contract c\r\n"
					+ "ON e.employee_id = c.employee_id AND c.date_to = (SELECT MAX(date_to) FROM contract WHERE employee_id = e.employee_id)\r\n"
					+ "LEFT JOIN contract_type ct\r\n"
					+ "ON c.contract_type_id = ct.contract_type_id\r\n"
					+ "WHERE e.is_active = 1;");
			
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.getResultList();
			
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			for (int i = 0; i < list.size(); i++) {
				Object[] objectData = list.get(i);
				employeeResponse = new EmployeeResponse();
				contractResponse = new ContractResponse();
				
				if(objectData[4] != null) {
					contractResponse.setDateFrom(simpleDateFormat.format((Date) objectData[4]));
				}
				
				if(objectData[5] != null) {
					contractResponse.setDateTo(simpleDateFormat.format((Date) objectData[5]));
				}
				
				contractResponse.setSalaryPerDay((BigDecimal) objectData[6]);
				
				employeeResponse.setContractResponse(contractResponse);
				
				employeeResponse.setFullname((String) objectData[0]);
				employeeResponse.setTaxIdNumber((String) objectData[1]);
				employeeResponse.setEmail((String) objectData[2]);
				
				listEmployeesResponses.add(employeeResponse);
			}
		} catch (Exception e) {
			return ErrorsResponse.internalServerError();
		} finally {
			entityManager.close();
		}
		
		return new ResponseEntity<List<EmployeeResponse>>(listEmployeesResponses, HttpStatus.OK);
	}
	
}
