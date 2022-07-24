package mx.com.udes.metaphorce.repository;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import mx.com.udes.metaphorce.model.Contract;
import mx.com.udes.metaphorceResponses.CustomResponse;
import mx.com.udes.metaphorceResponses.ErrorsResponse;

@Repository
public class ContractRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public BigInteger findContractByEmployee(Integer employee) {
		List<?> result = new ArrayList<>();
		BigInteger resultInt = new BigInteger("0");
		
		try {
			Query query = entityManager.createNativeQuery("SELECT MAX(contract_id) FROM contract WHERE employee_id = :employeeId")
					.setParameter("employeeId", employee);
			
			result = query.getResultList();
			
			if(!result.isEmpty()) {
				resultInt = (BigInteger) result.get(0);
			}
			
		} catch (Exception e) {
			resultInt = new BigInteger("-1");
		} finally {
			entityManager.close();
		}
		
		return resultInt;
	}
	
	@Transactional
	public ResponseEntity<?> saveContract(Contract contract) {
		try {
			entityManager.persist(contract);
		} catch (Exception e) {
			return ErrorsResponse.internalServerError();
		} finally {
			entityManager.close();
		}
		
		return ResponseEntity.ok().body(new CustomResponse(true, "Contrato creado exitosamente"));
	}
	
	@Transactional
	public ResponseEntity<?> updateContract(Integer contractId) {		
		try {
			String dateTo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
			Query query = entityManager.createNativeQuery("UPDATE contract SET date_to = :dateTo WHERE contract_id = :contractId");
			
			query.setParameter("dateTo", dateTo);
			query.setParameter("contractId", contractId);
			
			query.executeUpdate();
			
			return ResponseEntity.ok().body(new CustomResponse(true, "Contrato creado exitosamente"));
			
		} catch (Exception e) {
			return ErrorsResponse.internalServerError();
		} finally {
			entityManager.close();
		}
	}
	
}
