package mx.com.udes.metaphorceResponses;

import org.springframework.http.ResponseEntity;

public class ErrorsResponse {

	public static ResponseEntity<?> internalServerError() {
		return ResponseEntity.internalServerError().body(new CustomResponse(false, "Oh, ocurrió un error no controlado, por favor contacta al administrador"));
	}
	
	public static ResponseEntity<?> badRequestError(String msg) {
		return ResponseEntity.badRequest().body(new CustomResponse(false, msg));
	}
	
}
