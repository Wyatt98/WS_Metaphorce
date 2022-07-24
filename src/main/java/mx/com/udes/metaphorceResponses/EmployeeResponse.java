package mx.com.udes.metaphorceResponses;

public class EmployeeResponse {
	private String fullname;
	private String taxIdNumber;
	private String email;
	private ContractResponse contractResponse;
	
	public EmployeeResponse() {}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getTaxIdNumber() {
		return taxIdNumber;
	}

	public void setTaxIdNumber(String taxIdNumber) {
		this.taxIdNumber = taxIdNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContractResponse getContractResponse() {
		return contractResponse;
	}

	public void setContractResponse(ContractResponse contractResponse) {
		this.contractResponse = contractResponse;
	}	
}
