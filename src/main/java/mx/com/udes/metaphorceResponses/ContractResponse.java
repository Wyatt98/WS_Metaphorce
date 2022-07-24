package mx.com.udes.metaphorceResponses;

import java.math.BigDecimal;

public class ContractResponse {
	private String dateFrom;
	private String dateTo;
	private BigDecimal salaryPerDay;
	
	public ContractResponse() {}
	
	public ContractResponse(String dateFrom, String dateTo, BigDecimal salaryPerDay) {
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.salaryPerDay = salaryPerDay;
	}

	public String getDateFrom() {
		return dateFrom;
	}
	
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	
	public String getDateTo() {
		return dateTo;
	}
	
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	public BigDecimal getSalaryPerDay() {
		return salaryPerDay;
	}
	
	public void setSalaryPerDay(BigDecimal salaryPerDay) {
		this.salaryPerDay = salaryPerDay;
	}
	
}
