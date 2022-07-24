package mx.com.udes.metaphorce.validations;

public class Validations {
	public boolean validateRfc(String rfc){
		rfc = rfc.toUpperCase().trim();
		return rfc.toUpperCase().matches("[A-Z]{4}[0-9]{6}[A-Z0-9]{3}");
	}
}
